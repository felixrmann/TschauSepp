package TschauSepp.view;

import javax.swing.*;
import java.awt.*;
import java.security.KeyStore;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-Juni-28
 */

public class ExitView extends JDialog {
    private MainFrame mainFrame;
    private JPanel mainPanel, textPanel, buttonPanel;
    private JButton cancelButton, exitButton;
    private JTextArea textArea;

    public ExitView(MainFrame mainFrame){
        super(mainFrame, "Exit?", true);

        this.mainFrame = mainFrame;

        mainPanel = new JPanel();
        textPanel = new JPanel();
        buttonPanel = new JPanel();
        cancelButton = new JButton("Cancel");
        exitButton = new JButton("Exit");
        textArea = new JTextArea();

        init();

        setSize(190,100);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        getContentPane().add(mainPanel);

        mainPanel.setBackground(new Color(30,87,216));
        textPanel.setBackground(new Color(30,87,216));
        buttonPanel.setBackground(new Color(30,87,216));

        mainPanel.setLayout(new BorderLayout(10,10));
        mainPanel.add(textPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textArea, BorderLayout.CENTER);

        textArea.setText("Wollen Sie das Spiel verlassen?");
        textArea.setEditable(false);
        textArea.setFocusable(false);
        textArea.setBackground(null);

        buttonPanel.setLayout(new GridLayout(1,2));
        buttonPanel.add(cancelButton);
        buttonPanel.add(exitButton);

        cancelButton.addActionListener(e -> {
            this.dispose();
        });

        exitButton.addActionListener(e -> {
            mainFrame.setContent(new Menue(mainFrame));
            mainFrame.setFrameSize(400,500);
            this.dispose();
        });
    }
}
