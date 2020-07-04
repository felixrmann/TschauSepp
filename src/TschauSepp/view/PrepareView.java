package TschauSepp.view;

import TschauSepp.controller.PrepareController;
import TschauSepp.model.Modus;
import TschauSepp.model.Spieler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;
import java.util.Vector;

/**
 * The type Prepare view.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2020 -Mai-29
 */
public class PrepareView extends JPanel {
    private final MainFrame mainFrame;
    private final JPanel mainPanel;
    private final JPanel topPanel;
    private final JPanel midPanel;
    private final JPanel botPanel;
    private JPanel modusPanel;
    private final Vector<Spieler> spielerVector;
    private final JList<Spieler> spielerListe;
    private final JScrollPane scrollPane;
    private final JComboBox<String> modusAuswahl;
    private final JButton cancelButton;
    private final JButton playButton;
    private final JButton addPlayerButton;
    private final JButton removePlayerButton;
    private JTextField textField;

    /**
     * Instantiates a new Prepare view.
     *
     * @param mainFrame the main frame
     */
    public PrepareView(MainFrame mainFrame){
        this.mainFrame = mainFrame;

        mainPanel = new JPanel();
        topPanel = new JPanel();
        midPanel = new JPanel();
        botPanel = new JPanel();
        modusPanel = new JPanel();
        spielerVector = new Vector<>();
        spielerListe = new JList<>(spielerVector);
        textField = new JTextField(5);
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

        mainPanel.setBackground(new Color(30,87,216));
        topPanel.setBackground(new Color(30,87,216));
        midPanel.setBackground(new Color(30,87,216));
        botPanel.setBackground(new Color(30,87,216));
        scrollPane.setBackground(new Color(30,87,216));
        modusPanel.setBackground(new Color(30,87,216));

        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(386, 458));
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(midPanel, BorderLayout.CENTER);
        mainPanel.add(botPanel, BorderLayout.SOUTH);

        topPanel.setLayout(new BorderLayout());
        topPanel.add(addPlayerButton, BorderLayout.WEST);
        topPanel.add(removePlayerButton, BorderLayout.EAST);

        midPanel.setLayout(new BorderLayout(10,10));
        midPanel.add(scrollPane, BorderLayout.CENTER);
        midPanel.add(modusPanel, BorderLayout.SOUTH);

        modusPanel.setLayout(new BorderLayout());
        modusPanel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
        modusPanel.add(modusAuswahl, BorderLayout.CENTER);
        modusPanel.add(textField, BorderLayout.EAST);

        textField.setText("0");

        modusAuswahl.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));

        scrollPane.setPreferredSize(new Dimension(350,340));
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));

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
            if (getSpielerCount() <= 5 && getSpielerCount() > 1 && readyModus()){
                Modus modus = new Modus(getModus(), Integer.parseInt(textField.getText()));
                if (modus.getModus() == 'k'){
                    modus.setZielPunkte(0);
                }
                PrepareController.playButtonController(mainFrame, spielerVector, modus);
            }
        });

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                String value = textField.getText();
                int l = value.length();
                textField.setEditable(e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || KeyEvent.VK_BACK_SPACE == e.getKeyCode());
            }
        });

        modusAuswahl.addActionListener(e -> {
            textField.setVisible(Objects.equals(modusAuswahl.getSelectedItem(), "Punkte-Modus"));
        });
    }

    private boolean readyModus(){
        return !Objects.equals(modusAuswahl.getSelectedItem(), "Punkte-Modus") || !textField.getText().equals("");
    }

    /**
     * Get spieler count int.
     *
     * @return the int
     */
    int getSpielerCount(){
        return spielerVector.size();
    }

    /**
     * Add spieler.
     *
     * @param spieler the spieler
     */
    void addSpieler(Spieler spieler){
        if (getSpielerCount() < 5){
            spielerVector.add(spieler);
            spielerListe.updateUI();
        }
    }

    /**
     * Remove spieler.
     *
     * @param index the index
     */
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

    /**
     * The type Cell renderer.
     */
    static class CellRenderer extends JPanel implements ListCellRenderer<Spieler> {

        private final JPanel contentPanel;
        private final JPanel colorPanel;
        private final JPanel namePanel;
        private final JLabel nameLabel;

        /**
         * Instantiates a new Cell renderer.
         */
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
