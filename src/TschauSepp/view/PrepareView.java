package TschauSepp.view;

import TschauSepp.controller.PrepareController;
import TschauSepp.model.Spieler;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-Mai-29
 */

public class PrepareView extends JPanel {
    private final MainFrame mainFrame;
    private final JPanel mainPanel;
    private final JPanel topPanel;
    private final JPanel midPanel;
    private final JPanel botPanel;
    private final Vector<Spieler> spielerVector;
    private final JList<Spieler> spielerListe;
    private final JScrollPane scrollPane;
    private final JComboBox<String> modusAuswahl;
    private final JButton cancelButton;
    private final JButton playButton;
    private final JButton addPlayerButton;
    private final JButton removePlayerButton;

    public PrepareView(MainFrame mainFrame){
        this.mainFrame = mainFrame;

        mainPanel = new JPanel();
        topPanel = new JPanel();
        midPanel = new JPanel();
        botPanel = new JPanel();
        spielerVector = new Vector<>();
        spielerListe = new JList<>(spielerVector);
        spielerListe.setCellRenderer(new CellRenderer());
        scrollPane = new JScrollPane(spielerListe, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        String[] modi = new String[]{"Punkte-Modus", "Karten-Modus"};
        modusAuswahl = new JComboBox<>(modi);
        cancelButton = new JButton("cancel");
        playButton = new JButton("Play");
        addPlayerButton = new JButton("add Player");
        removePlayerButton = new JButton("removePlayer");

        init();
    }

    private void init(){
        add(mainPanel);

        mainPanel.setLayout(new BorderLayout(10,10));
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(midPanel, BorderLayout.CENTER);
        mainPanel.add(botPanel, BorderLayout.SOUTH);

        topPanel.setLayout(new BorderLayout());
        topPanel.add(addPlayerButton, BorderLayout.WEST);
        topPanel.add(removePlayerButton, BorderLayout.EAST);

        midPanel.setLayout(new BorderLayout(10,10));
        midPanel.add(scrollPane, BorderLayout.CENTER);
        midPanel.add(modusAuswahl, BorderLayout.SOUTH);

        scrollPane.setPreferredSize(new Dimension(350,340));

        botPanel.setLayout(new BorderLayout());
        botPanel.add(cancelButton, BorderLayout.WEST);
        botPanel.add(playButton, BorderLayout.EAST);

        addPlayerButton.addActionListener(e -> PrepareController.addPlayerButtonController(mainFrame, this));

        removePlayerButton.addActionListener(e -> {
            if (!spielerListe.isSelectionEmpty()){
                PrepareController.removePlayerButtonController(this, spielerListe.getSelectedIndex());
            }
        });

        cancelButton.addActionListener(e -> PrepareController.cancelButtonController(mainFrame));

        playButton.addActionListener(e -> {
            if (getSpielerCount() <= 5 && getSpielerCount() > 1){
                PrepareController.playButtonController(mainFrame, spielerVector, getModus());
            } else {
                //TODO Exception für anzahl spieler
                System.err.println("Falsche anzahl Spieler");
            }
        });
    }

    int getSpielerCount(){
        return spielerVector.size();
    }

    void addSpieler(Spieler spieler){
        if (getSpielerCount() < 5){
            spielerVector.add(spieler);
            spielerListe.updateUI();
        } else {
            //TODO Exception für zu viele Spieler
            System.err.println("Zu viele Spieler");
        }
    }

    public void removeSpieler(int index){
        spielerVector.remove(index);
        spielerListe.repaint();
    }

    private char getModus(){
        if (modusAuswahl.getSelectedIndex() == 0){
            return 'p';
        } else {
            return 'k';
        }
    }

    static class CellRenderer extends JPanel implements ListCellRenderer<Spieler> {

        private final JPanel contentPanel;
        private final JPanel colorPanel;
        private final JPanel namePanel;
        private final JLabel nameLabel;

        CellRenderer(){
            contentPanel = new JPanel();
            nameLabel = new JLabel();
            namePanel = new JPanel();
            colorPanel = new JPanel();
        }
        @Override
        public Component getListCellRendererComponent(
                        JList<? extends Spieler> list,
                        Spieler value,
                        int index,
                        boolean isSelected,
                        boolean cellHasFocus)
        {
            removeAll();
            setPreferredSize(new Dimension(300,35));
            setBackground(Color.BLACK);
            add(contentPanel);

            contentPanel.setLayout(new GridLayout(1,2));
            contentPanel.add(namePanel);
            contentPanel.add(colorPanel);

            namePanel.setLayout(new BorderLayout(100,30));
            namePanel.add(nameLabel, BorderLayout.WEST);

            nameLabel.setText(value.getName());

            colorPanel.setBackground(value.getFarbe());

            if (isSelected){
                setBackground(list.getSelectionBackground());
            } else {
                setBackground(list.getBackground());
            }

            return this;
        }
    }
}
