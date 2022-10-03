import contrats.Bill;

import javax.swing.*;

public class BillPanel   {
    private JFrame f;
    Bill bill;
    JButton confirmButton;
    private JPanel jPanel;

    public BillPanel(Bill bill){
        this.bill=bill;

        f = new JFrame("Bill");
        jPanel = new JPanel();
        confirmButton = new JButton("Confirm");
        JLabel label = new JLabel("Movie: "+bill.getMovieName()+" Price: "+bill.getOutrageousPrice());

        confirmButton.addActionListener(e -> {
            f.dispose();
            JOptionPane.showMessageDialog(this.f,
                     "transaction completed",
                    "Bill",
                    JOptionPane.INFORMATION_MESSAGE);

        });

        jPanel.add(label);
        jPanel.add(confirmButton);
        f.add(jPanel);
        f.setSize(300, 300);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);


    }


}
