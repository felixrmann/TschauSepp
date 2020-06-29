package TschauSepp.view;

import TschauSepp.controller.GameController;
import TschauSepp.model.Ablagestapel;
import TschauSepp.model.Game;
import TschauSepp.model.Kartenstapel;
import TschauSepp.model.Spieler;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Vector;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-Juni-04
 */

public class GameView extends JPanel {
    private MainFrame mainFrame;
    private Game game;
    private Kartenstapel kartenstapel;
    private Ablagestapel ablagestapel;
    private Vector<Spieler> spielerListe;
    private char modus;
    private JPanel mainPanel, topPanel, botPanel, centerPanel, centerRightPanel, centerRightCardPanel, centerRCCPanel, centerLeftPanel, centerLeftCardPanel, centerLCCPanel, westPanel, playerPanel, movePanel, movePanelContent, cardPanel, sayPanel, sayPanelContent;
    private JScrollPane scrollPane;
    private JList<ImageIcon> cardList;
    private DefaultListModel<ImageIcon> defaultListModel;
    private JLabel topLabel;
    private JTextArea textArea;
    private JButton legenButton, ziehenButton, tschauButton, seppButton, exitButton;
    private Spieler currentSpieler, winner;

    public GameView(MainFrame mainFrame, Vector<Spieler> spielerListe, char modus){
        this.mainFrame = mainFrame;
        this.spielerListe = spielerListe;
        this.modus = modus;

        kartenstapel = new Kartenstapel();
        setPlayerCards(spielerListe, kartenstapel);

        game = new Game(this);

        defaultListModel = new DefaultListModel<>();
        cardList = new JList<>(defaultListModel);
        scrollPane = new JScrollPane(cardList);
        mainPanel = new JPanel();
        topPanel = new JPanel();
        botPanel = new JPanel();
        centerPanel = new JPanel();
        centerLeftPanel = new JPanel();
        centerRightPanel = new JPanel();
        centerLeftCardPanel = new JPanel();
        centerRightCardPanel = new JPanel();
        centerLCCPanel = new JPanel();
        centerRCCPanel = new JPanel();
        westPanel = new JPanel();
        playerPanel = new JPanel();
        movePanel = new JPanel();
        movePanelContent = new JPanel();
        cardPanel = new JPanel();
        sayPanel = new JPanel();
        sayPanelContent = new JPanel();
        topLabel = new JLabel();
        textArea = new JTextArea();
        legenButton = new JButton("Legen");
        ziehenButton = new JButton("Ziehen");
        tschauButton = new JButton("Tschau");
        seppButton = new JButton("Sepp");
        exitButton = new JButton("Exit");
        currentSpieler = spielerListe.get(0);
        winner = null;

        init();

        if (modus == 'k'){
            textArea.setVisible(false);
            mainFrame.setFrameSize(900,880);
        }

        setAreaText();
        loadNetxtPlayerPanel();

        runGame();
    }

    private void setPlayerCards(Vector<Spieler> spielerListe, Kartenstapel kartenstapel) {
        for (Spieler spieler : spielerListe) {
            for (int j = 0; j < 7; j++) {
                spieler.addKarte(kartenstapel.getRandomKarteAndRemove());
            }
        }
    }

    private void runGame(){
        while (winner == null){
            game.nextRound();

            if (kartenstapel.getAnzKarten() <= 5){
                kartenstapel.addKartenset();

            }
        }
    }

    private void init(){
        add(mainPanel);

        mainPanel.setLayout(new BorderLayout(10,10));
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(westPanel, BorderLayout.WEST);
        mainPanel.add(botPanel, BorderLayout.SOUTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        topPanel.setLayout(new BorderLayout());
        topPanel.add(topLabel, BorderLayout.CENTER);
        topPanel.add(textArea, BorderLayout.EAST);

        textArea.setPreferredSize(new Dimension(383,35));

        //TODO current Spieler
        topLabel.setText("Spieler 1");

        westPanel.setLayout(new BorderLayout(10,10));
        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(100,50));
        westPanel.add(panel1, BorderLayout.NORTH);
        westPanel.add(playerPanel, BorderLayout.CENTER);
        westPanel.add(panel1, BorderLayout.SOUTH);

        playerPanel.setLayout(new GridLayout(spielerListe.size() - 1, 1));

        botPanel.setLayout(new BorderLayout());
        botPanel.add(movePanel, BorderLayout.WEST);
        botPanel.add(cardPanel, BorderLayout.CENTER);
        botPanel.add(sayPanel, BorderLayout.EAST);

        movePanel.setLayout(new BorderLayout(5,5));
        movePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        movePanel.add(movePanelContent, BorderLayout.CENTER);

        GridLayout moveGrid = new GridLayout(2,1);
        moveGrid.setVgap(40);
        movePanelContent.setLayout(moveGrid);
        movePanelContent.setBorder(BorderFactory.createEmptyBorder(40,10,40,10));
        movePanelContent.add(legenButton);
        movePanelContent.add(ziehenButton);

        cardPanel.setPreferredSize(new Dimension(650,200));
        cardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cardPanel.add(scrollPane);

        cardList.setVisibleRowCount(1);
        cardList.setLayoutOrientation(JList.HORIZONTAL_WRAP);

        scrollPane.setPreferredSize(new Dimension(640,190));
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        paintCurrentPlayerCards();

        sayPanel.setLayout(new BorderLayout(5,5));
        sayPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        sayPanel.add(sayPanelContent, BorderLayout.CENTER);
        GridLayout sayGrid = new GridLayout(3,1);
        sayGrid.setVgap(30);
        sayPanelContent.setLayout(sayGrid);
        sayPanelContent.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        sayPanelContent.add(tschauButton);
        sayPanelContent.add(seppButton);
        sayPanelContent.add(exitButton);

        centerPanel.setLayout(new GridLayout(1,2));
        centerPanel.setPreferredSize(new Dimension(300,580));
        centerPanel.add(centerLeftPanel);
        centerPanel.add(centerRightPanel);

        centerLeftPanel.setLayout(new BorderLayout());
        centerLeftPanel.setBackground(Color.CYAN);
        centerLeftPanel.add(centerLeftCardPanel, BorderLayout.EAST);

        centerLeftCardPanel.setLayout(new GridLayout(3,1));
        centerLeftCardPanel.add(new JPanel());
        centerLeftCardPanel.add(centerLCCPanel);
        centerLeftCardPanel.add(new JPanel());

        centerLCCPanel.setLayout(new BorderLayout(10,10));
        centerLCCPanel.setBackground(Color.RED);
        //TODO Bild von Karte laden

        centerRightPanel.setLayout(new BorderLayout());
        centerRightPanel.setBackground(Color.BLUE);
        centerRightPanel.add(centerRightCardPanel, BorderLayout.WEST);

        centerRightCardPanel.setLayout(new GridLayout(3,1));
        centerRightCardPanel.add(new JPanel());
        centerRightCardPanel.add(centerRCCPanel);
        centerRightCardPanel.add(new JPanel());

        centerRCCPanel.setLayout(new BorderLayout(10,10));
        centerRCCPanel.setBackground(Color.RED);
        //TODO Bild von Karte laden

        legenButton.addActionListener(e -> {
            if (!cardList.isSelectionEmpty()){
                GameController.legenButtonController(currentSpieler, ablagestapel, currentSpieler.getHandkarten().get(cardList.getSelectedIndex()));
            }
        });

        ziehenButton.addActionListener(e -> {

        });

        tschauButton.addActionListener(e -> {
            GameController.tschauButtonController();
        });

        seppButton.addActionListener(e -> {
            GameController.seppButtonController(currentSpieler);
        });

        exitButton.addActionListener(e -> GameController.exitButtonController(mainFrame));
    }

    private void paintCurrentPlayerCards(){
        for (int i = 0; i < currentSpieler.getHandkarten().size(); i++) {
            URL path = currentSpieler.getHandkarten().get(i).getPath();
            ImageIcon imageIcon = new ImageIcon(path);
            Image image = imageIcon.getImage();
            Image newimg = image.getScaledInstance(115, 170, java.awt.Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(newimg);
            defaultListModel.addElement(imageIcon);
        }
    }

    private void loadNetxtPlayerPanel(){
        for (int i = 0; i < spielerListe.size(); i++) {
            JPanel panel = new JPanel();

            //TODO nächste Spieler anzeigen

            westPanel.add(panel);
        }
    }

    private void setAreaText(){
        //TODO mit Tabelle lösen
        StringBuilder s = new StringBuilder();
        for (Spieler spieler : spielerListe) {
            s.append(spieler.getName()).append("\t");
        }
        s.append("\n");
        for (Spieler spieler : spielerListe) {
            s.append(spieler.getPunktestand()).append("\t");
        }
        textArea.setText(s.toString());
    }

    private char getModus(){
        return modus;
    }

    public void areThereCards(){
        kartenstapel.hasCards();
    }

    public void setWinner(){
        this.winner = currentSpieler;
    }

    public void setCurrentSpieler(Spieler spieler) {
        this.currentSpieler = spieler;
    }

    public Vector<Spieler> getSpielerListe(){
        return spielerListe;
    }
}
