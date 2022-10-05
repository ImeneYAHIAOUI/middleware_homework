import contrats.IClientBox;
import contrats.IVODService;
import contrats.MovieDesc;
import contrats.MovieDescExtended;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.rmi.RemoteException;
import java.util.List;

public class CatalogList {

    IVODService VODService;
    private JFrame f;
    private JList jList;
    private JPanel jPanel;
    private JTextArea jTextArea;

    private JButton chooseButton;

    private JButton teaserButton;

    private IClientBox clientBox;

    public CatalogList(IVODService VODService, IClientBox clientBox) throws RemoteException {
        this.VODService = VODService;
        this.clientBox = clientBox;
        List<MovieDesc> catalog = VODService.viewCatalog();
        f = new JFrame("Catalog");
        jPanel = new JPanel();
        jList = new JList();
        jTextArea = new JTextArea();
        chooseButton = new JButton("Select Movie");
        teaserButton = new JButton("Teaser");
        teaserButton.setEnabled(false);

        jList.setModel(new AbstractListModel() {

            String[] strings = catalog.stream().map(movie -> movie.MovieName).toArray(String[]::new);

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public Object getElementAt(int i) {
                return strings[i];
            }
        });
        jList.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent evt) {
                jListValueChanged(evt);
            }
        });

        chooseButton.addActionListener(e -> {
            if(jList.getSelectedIndex() != -1){
                f.dispose();
                try {


                    new BillPanel(VODService.playmovie(catalog.get(jList.getSelectedIndex()).Isbn, clientBox), clientBox.getVideoBytes());
                } catch (RemoteException ex) {
                    throw new RuntimeException(ex);
                }
                }
           else
           {
                JOptionPane.showMessageDialog(f, "Please select a movie","no movie selected",JOptionPane.ERROR_MESSAGE);
            }


        });
        teaserButton.addActionListener(e -> {

            try {
                if(catalog.get(jList.getSelectedIndex()) instanceof MovieDescExtended){
                    new TeaserPanel( ((MovieDescExtended) catalog.get(jList.getSelectedIndex())).getTeaser());
                }
            } catch (RemoteException ex) {
                throw new RuntimeException(ex);
            }
        });
        jTextArea.setColumns(20);
        jTextArea.setWrapStyleWord(true);
        jTextArea.setLineWrap(true);

        jPanel.add(jList);
        jPanel.add(jTextArea);
        jPanel.add(chooseButton);
        jPanel.add(teaserButton);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.add(jPanel);
        f.setSize(500, 300);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - f.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - f.getHeight()) / 2);
        f.setLocation(x, y);
        f.setVisible(true);
    }


    private void jListValueChanged(javax.swing.event.ListSelectionEvent evt) {
        int index = jList.getSelectedIndex();
        try {
            jTextArea.setText(VODService.viewCatalog().get(index).affiche());
            if (VODService.viewCatalog().get(index) instanceof contrats.MovieDescExtended) {
                teaserButton.setEnabled(true);
            }
            else {
                teaserButton.setEnabled(false);
            }
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }

    }
}




