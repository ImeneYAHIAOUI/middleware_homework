import contrats.Bill;

import javax.swing.*;
import java.awt.*;

public class BillPanel   {
    private JFrame f;
    Bill bill;
    JButton confirmButton;
    private JPanel jPanel;

    byte[] videoBytes;

    public BillPanel(Bill bill, byte[] videoBytes) {
        this.bill=bill;
        this.videoBytes=videoBytes;

        f = new JFrame("Bill");
        jPanel = new JPanel(new GridBagLayout());
        confirmButton = new JButton("Confirm");
        confirmButton.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints cs = new GridBagConstraints();
        JLabel label = new JLabel("Chosen movie: "+bill.getMovieName(),SwingConstants.CENTER);

        cs.gridx = 0;
        cs.gridy = 1;
        jPanel.add(label,cs);
        JLabel label2 = new JLabel("Price: "+bill.getOutrageousPrice(),SwingConstants.CENTER);
        cs.gridx = 0;
        cs.gridy = 3;
        jPanel.add(label2,cs);
        confirmButton.addActionListener(e -> {
            f.dispose();
            JOptionPane optPane = new JOptionPane("film purchased",JOptionPane.YES_OPTION);
            optPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);

            JPanel buttonPanel = (JPanel)optPane.getComponent(1);

            JButton button = (JButton)buttonPanel.getComponent(0);

            button.setText("Start streaming");

            JDialog d = optPane.createDialog(null,"transaction completed");
            d.show();




        });

        cs.gridx = 0;
        cs.gridy = 5;
        jPanel.add(confirmButton,cs);
        f.add(jPanel);
        f.setSize(500,100);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - f.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - f.getHeight()) / 2);
        f.setLocation(x, y);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);


    }


}
