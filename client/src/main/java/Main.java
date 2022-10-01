import contrats.IConnection;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        IConnection connection = null;

        try {
            Registry r =  LocateRegistry.getRegistry(1099);
            connection = (IConnection) r.lookup("Connection");

            JFrame frame = new JFrame("VOD service");
            JButton RegisterBtn = new JButton("Click to register");
            JButton loginBtn = new JButton("Click to login");

            IConnection finalConnection = connection;

            loginBtn.addActionListener(
                    new ActionListener(){
                        public void actionPerformed(ActionEvent e) {
                            LoginDialog loginDlg = new LoginDialog(frame, finalConnection);
                            loginDlg.setVisible(true);
                            // if logon successfully
                            if(loginDlg.isSucceeded()){
                                frame.dispose();
                                RegisterDialog registerDlg = new RegisterDialog(frame, finalConnection);
                            }
                        }
                    });
            RegisterBtn.addActionListener(
                    new ActionListener(){
                        public void actionPerformed(ActionEvent e) {
                            RegisterDialog registerDlg = new RegisterDialog(frame, finalConnection);
                            registerDlg.setVisible(true);
                            // if registered successfully

                        }
                    });

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        }





    }
}

