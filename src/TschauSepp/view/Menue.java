package TschauSepp.view;

import TschauSepp.controller.MenueController;

import javax.swing.*;
import java.awt.*;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-Mai-29
 */

public class Menue extends JPanel{
    private MainFrame mainFrame;
    private JPanel mainPanel, mainmainPanel, topPanel, botPanel, botMidPanel;
    private JButton playButton, regelnButton, exitButton;

    public Menue(MainFrame mainFrame){
        this.mainFrame = mainFrame;

        mainPanel = new JPanel();
        mainmainPanel = new JPanel();
        topPanel = new JPanel();
        botPanel = new JPanel();
        botMidPanel = new JPanel();


        playButton = new JButton("Play");
        regelnButton = new JButton("Regeln");
        exitButton = new JButton("Exit");

        init();
    }

    private void init(){
        add(mainPanel);

        mainPanel.setLayout(new BorderLayout(10,10));
        mainPanel.add(mainmainPanel);

        mainmainPanel.setLayout(new GridLayout(2,1));
        mainmainPanel.add(topPanel);
        mainmainPanel.add(botPanel);

        //TODO topPanel (Titel oder sowas)

        botPanel.setLayout(new GridLayout(1, 3));
        botPanel.add(new JPanel());
        botPanel.add(botMidPanel);
        botPanel.add(new JPanel());

        GridLayout grid = new GridLayout(3,1);
        grid.setVgap(50);
        botMidPanel.setLayout(grid);
        botMidPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        botMidPanel.add(playButton);
        botMidPanel.add(regelnButton);
        botMidPanel.add(exitButton);

        playButton.addActionListener(e -> MenueController.playButtonController(mainFrame));
        regelnButton.addActionListener(e -> MenueController.regelnButtonController(mainFrame));
        exitButton.addActionListener(e -> MenueController.exitButtonController());
    }
}
