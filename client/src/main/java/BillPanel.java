import contrats.Bill;

import javax.swing.*;
import java.awt.*;

public class BillPanel   {
    private JFrame f;
    Bill bill;
    JButton confirmButton;
    private JPanel jPanel;

    public BillPanel(Bill bill){
        this.bill=bill;

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
            JOptionPane.showMessageDialog(this.f,
                     "transaction completed",
                    "Bill",
                    JOptionPane.INFORMATION_MESSAGE);

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
