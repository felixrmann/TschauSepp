package TschauSepp.view;

import TschauSepp.model.Karte;

import javax.swing.*;
import java.awt.*;

/**
 * The type Auswahl view.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2020 -Juli-01
 */
public class AuswahlView extends JDialog {
    private GameView gameView;
    private JPanel mainPanel, topPanel, auswahlPanel, botPanel;
    private JLabel textLabel;
    private JButton roseButton, schellenButton, schildButton, eichelButton;

    /**
     * Instantiates a new Auswahl view.
     *
     * @param mainFrame the main frame
     * @param gameView  the game view
     */
    public AuswahlView(MainFrame mainFrame, GameView gameView){
        super(mainFrame, "Wähle aus", true);

        this.gameView = gameView;

        mainPanel = new JPanel();
        topPanel = new JPanel();
        auswahlPanel = new JPanel();
        botPanel = new JPanel();

        textLabel = new JLabel();

        roseButton = new JButton("Rose");
        schellenButton = new JButton("Schellen");
        schildButton = new JButton("Schild");
        eichelButton = new JButton("Eichel");

        init();

        setSize(150,150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        getContentPane().add(mainPanel);

        mainPanel.setBackground(new Color(30,87,216));
        topPanel.setBackground(new Color(30,87,216));
        auswahlPanel.setBackground(new Color(30,87,216));
        botPanel.setBackground(new Color(30,87,216));

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(auswahlPanel, BorderLayout.CENTER);

        topPanel.setLayout(new BorderLayout());
        topPanel.add(textLabel, BorderLayout.CENTER);

        textLabel.setText("Bitte wählen Sie eine Farbe aus.");

        auswahlPanel.setLayout(new GridLayout(2,2));
        auswahlPanel.add(eichelButton);
        auswahlPanel.add(schellenButton);
        auswahlPanel.add(schildButton);
        auswahlPanel.add(roseButton);

        eichelButton.addActionListener(e -> setNextCard("e_"));
        schildButton.addActionListener(e -> setNextCard("si"));
        schellenButton.addActionListener(e -> setNextCard("se"));
        roseButton.addActionListener(e -> setNextCard("r_"));
    }

    /**
     * Set next card.
     *
     * @param welche the welche
     */
    public void setNextCard(String welche){
        switch (welche){
            case "e_":
                gameView.setTopCard(new Karte(getClass().getResource("../img/e_0_.gif"), "e_0_", 0));
                break;
            case "si":
                gameView.setTopCard(new Karte(getClass().getResource("../img/si0_.gif"), "si0_", 0));
                break;
            case "se":
                gameView.setTopCard(new Karte(getClass().getResource("../img/se0_.gif"), "se0_", 0));
                break;
            case "r_":
                gameView.setTopCard(new Karte(getClass().getResource("../img/r_0_.gif"), "r_0_", 0));
                break;
        }
        this.dispose();
    }
}
