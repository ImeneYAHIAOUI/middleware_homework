import javax.swing.*;
import java.awt.*;
import java.nio.charset.StandardCharsets;

public class TeaserPanel {
    JFrame f;
    JPanel panel;
    JLabel label;

    public TeaserPanel(byte[] video){
        f = new JFrame("Teaser");
        panel = new JPanel(new GridBagLayout());
        label = new JLabel(new String(video, StandardCharsets.UTF_8));
        label.resize(label.preferredSize());
        GridBagConstraints cs = new GridBagConstraints();

        panel.add(label);
        f.add(panel);
        f.setSize(500,100);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - f.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - f.getHeight()) / 2);
        f.setLocation(x, y);
        f.setVisible(true);

    }
}
