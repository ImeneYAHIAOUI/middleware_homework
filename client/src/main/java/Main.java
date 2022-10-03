import contrats.IClientBox;
import contrats.IConnection;
import contrats.IVODService;

import javax.swing.*;
import java.awt.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) throws RemoteException {
        IConnection connection = null;

        IClientBox box = new ClientBox();

        try {
            Registry r =  LocateRegistry.getRegistry(1099);
            connection = (IConnection) r.lookup("Connection");

            JFrame frame = new JFrame("VOD service");
            JButton RegisterBtn = new JButton("Click to register");
            JButton loginBtn = new JButton("Click to login");

            IConnection finalConnection = connection;


            loginBtn.addActionListener(
                    e -> {
                        LoginDialog loginDlg = new LoginDialog(frame, finalConnection);
                        loginDlg.setVisible(true);
                        if (loginDlg.isSucceeded()) {
                            IVODService VODService = loginDlg.getVODService();

                            SwingUtilities.invokeLater(new Runnable() {

                                @Override
                                public void run() {
                                    try {
                                        new CatalogList(VODService, box);
                                    } catch (RemoteException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                }
                            });
                        }

                    });
            RegisterBtn.addActionListener(
                    e -> {
                        RegisterDialog registerDlg = new RegisterDialog(frame, finalConnection);
                        registerDlg.setVisible(true);

                    });
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 100);
            frame.setLayout(new FlowLayout());
            frame.getContentPane().add(loginBtn);
            frame.getContentPane().add(RegisterBtn);
            frame.setVisible(true);

        } catch (RemoteException | NotBoundException e) {
            throw new RuntimeException(e);
        }


    }
}

