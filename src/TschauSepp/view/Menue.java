package TschauSepp.view;

import TschauSepp.controller.MenueController;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-Mai-29
 */

public class Menue extends JPanel{
    private MainFrame mainFrame;
    private JPanel mainPanel, topPanel, botPanel, botMidPanel;
    private JButton playButton, regelnButton, exitButton;

    public Menue(MainFrame mainFrame){
        this.mainFrame = mainFrame;

        mainPanel = new JPanel();
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

        mainPanel.setBackground(new Color(30,87,216));
        topPanel.setBackground(new Color(30,87,216));
        botMidPanel.setBackground(new Color(30,87,216));
        botPanel.setBackground(new Color(30,87,216));

        mainPanel.setLayout(new GridLayout(2,1));
        mainPanel.setPreferredSize(new Dimension(400,458));
        mainPanel.add(topPanel);
        mainPanel.add(botPanel);

        URL path1 = this.getClass().getResource("../img/titleimg.png");
        ImageIcon imageIcon1 = new ImageIcon(path1);
        Image image1 = imageIcon1.getImage();
        Image newimg1 = image1.getScaledInstance(400, 200, java.awt.Image.SCALE_SMOOTH);
        imageIcon1 = new ImageIcon(newimg1);
        JLabel img1 = new JLabel();
        img1.setIcon(imageIcon1);
        topPanel.add(img1);

        //TODO topPanel (Titel oder sowas)

        botPanel.setLayout(new GridLayout(1, 3));
        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(30,87,216));
        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(30,87,216));
        botPanel.add(panel1);
        botPanel.add(botMidPanel);
        botPanel.add(panel2);

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
