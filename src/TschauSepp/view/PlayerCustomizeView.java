package TschauSepp.view;

import TschauSepp.model.Spieler;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-Mai-30
 */

public class PlayerCustomizeView extends JDialog {
    private PrepareView prepareView;
    private AbstractColorChooserPanel hsvPanel;
    private JPanel mainPanel, mainContentPanel, topPanel, botPanel, botButtonPanel;
    private JLabel nameLabel, farbeLabel;
    private JTextField nameField;
    private JButton canelButton, saveBtton;

    public PlayerCustomizeView(MainFrame parent, PrepareView prepareView){
        super(parent, "Erstellen Sie ihren Spieler", true);

        this.prepareView = prepareView;

        JColorChooser colorChooser = new JColorChooser();
        hsvPanel = colorChooser.getChooserPanels()[0];
        mainPanel = new JPanel();
        mainContentPanel = new JPanel();
        topPanel = new JPanel();
        botPanel = new JPanel();
        botButtonPanel = new JPanel();
        nameLabel = new JLabel("Geben Sie hier ihren Namen ein. Min 1, Max 10 Zeichen.");
        farbeLabel = new JLabel("Wählen Sie ihre Farbe aus.");
        nameField = new JTextField("Spieler" + (prepareView.getSpielerCount() + 1), 10);
        canelButton = new JButton("cancel");
        saveBtton = new JButton("Save");

        init();

        setLocationRelativeTo(null);
        setSize(450,400);
        setVisible(true);
    }

    private void init(){
        getContentPane().add(mainPanel);

        mainPanel.setLayout(new BorderLayout(10,10));
        mainPanel.add(mainContentPanel, BorderLayout.CENTER);
        mainPanel.add(botButtonPanel, BorderLayout.SOUTH);

        mainContentPanel.setLayout(new GridLayout(2,1));
        mainContentPanel.add(topPanel);
        mainContentPanel.add(botPanel);

        topPanel.setLayout(new BorderLayout(10,10));
        topPanel.setPreferredSize(new Dimension(400,50));
        topPanel.add(nameLabel, BorderLayout.NORTH);
        topPanel.add(nameField, BorderLayout.CENTER);

        botPanel.setLayout(new BorderLayout(10,10));
        botPanel.add(farbeLabel, BorderLayout.NORTH);
        botPanel.add(hsvPanel, BorderLayout.CENTER);

        botButtonPanel.setLayout(new BorderLayout());
        botButtonPanel.add(canelButton, BorderLayout.WEST);
        botButtonPanel.add(saveBtton, BorderLayout.EAST);

        canelButton.addActionListener(e -> this.dispose());

        saveBtton.addActionListener(e -> {
            //TODO alles in einem JUnit Testfall hinzufügen
            if (!nameField.getText().equals("")){
                if (nameField.getText().length() <= 10){
                    prepareView.addSpieler(new Spieler(nameField.getText(), hsvPanel.getColorSelectionModel().getSelectedColor()));
                    this.dispose();
                } else {
                    nameField.setText("Zu lang");
                    java.util.Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            nameField.setText("Spieler" + (prepareView.getSpielerCount() + 1));
                        }
                    }, 2000);
                }
            } else {
                nameField.setBorder(BorderFactory.createLineBorder(Color.RED));
                java.util.Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        nameField.setBorder(BorderFactory.createLineBorder(null));
                        nameField.setText("Spieler" + (prepareView.getSpielerCount() + 1));
                    }
                }, 2000);
            }
        });
    }
}
