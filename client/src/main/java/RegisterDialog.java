import contrats.IConnection;
import contrats.SignInFailedException;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;


public class RegisterDialog extends JDialog {


    private JTextField tfMail;
    private JPasswordField pfPassword;
    private JLabel lbMail;
    private JLabel lbPassword;
    private JButton btnLogin;
    private JButton btnCancel;
    private boolean succeeded;

    IConnection connection;
    public RegisterDialog(Frame parent,IConnection connection)
    {
        super(parent, "Register", true);


        this.connection = connection;

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
        lbMail = new JLabel("Mail: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbMail, cs);

        tfMail = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfMail, cs);

        lbPassword = new JLabel("Password: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbPassword, cs);

        pfPassword = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(pfPassword, cs);
        panel.setBorder(new LineBorder(Color.GRAY));

        btnLogin = new JButton("Register");
        btnLogin.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    connection.signIn(getMail(), getPassword());
                    JOptionPane.showMessageDialog(RegisterDialog.this,
                             "Your account has been created.",
                            "Register",
                            JOptionPane.INFORMATION_MESSAGE);
                    succeeded = true;
                    dispose();
                } catch (SignInFailedException e1) {
                    JOptionPane.showMessageDialog(RegisterDialog.this,
                            e1.getMessage(),
                            "register",
                            JOptionPane.ERROR_MESSAGE);
                    // reset Mail and password
                    tfMail.setText("");
                    pfPassword.setText("");
                    succeeded = false;

                } catch (RemoteException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        JPanel bp = new JPanel();
        bp.add(btnLogin);
        bp.add(btnCancel);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);

        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }

    public String getMail() {
        return tfMail.getText().trim();
    }

    public String getPassword() {
        return new String(pfPassword.getPassword());
    }

    public boolean isSucceeded() {
        return succeeded;
    }


}
