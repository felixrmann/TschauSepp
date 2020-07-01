package TschauSepp.view;

import javax.swing.*;
import java.awt.*;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-Mai-30
 */

public class RegelnView extends JPanel {
    private MainFrame mainFrame;
    private JPanel mainPanel, topPanel, midPanel, botPanel;
    private JTextArea textArea;
    private JButton andereRegelnButton, cancelButton;
    private char modus;
    private String p;
    private String k;

    public RegelnView(MainFrame mainFrame){
        this.mainFrame = mainFrame;

        mainPanel = new JPanel();
        topPanel = new JPanel();
        midPanel = new JPanel();
        botPanel = new JPanel();
        textArea = new JTextArea(23,35);
        andereRegelnButton = new JButton("Karten-Regeln");
        cancelButton = new JButton("cancel");
        modus = 'p';

        p =     "Punkte - Regeln\n\n" +
                "Beim Punkte-Modus könnt ihr auswählen, \n" +
                "auf wie viele Punkte ihr spielen wollt.\n" +
                "Das Spiel wird erst beendet, wenn einer\n" +
                "von euch die erforderlichen Punkte\n" +
                "erreicht habt. \n\n\n" +
                "Viel Glück";

        k =     "Karten - Regeln\n\n" +
                "Beim Karten-Modus geht es darum, \n" +
                "welcher Spieler am schnellsten mit \n" +
                "seiner Hand fertig ist, sie also \n" +
                "abgelegt hat.\n\n\n" +
                "Viel Glück";

        init();
    }

    private void init(){
        add(mainPanel);

        mainPanel.setBackground(new Color(30,87,216));
        topPanel.setBackground(new Color(30,87,216));
        midPanel.setBackground(new Color(30,87,216));
        botPanel.setBackground(new Color(30,87,216));

        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(386,458));
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(midPanel, BorderLayout.CENTER);
        mainPanel.add(botPanel, BorderLayout.SOUTH);

        topPanel.setLayout(new BorderLayout(10,10));
        topPanel.add(andereRegelnButton, BorderLayout.WEST);

        midPanel.setLayout(new BorderLayout(10,10));
        midPanel.add(textArea, BorderLayout.CENTER);

        textArea.setText(p);
        textArea.setEditable(false);
        textArea.setFocusable(false);
        textArea.setBackground(null);

        botPanel.setLayout(new BorderLayout(10,10));
        botPanel.add(cancelButton, BorderLayout.WEST);

        andereRegelnButton.addActionListener(e -> {
            if (modus == 'p'){
                textArea.setText(k);
                changeModus();
                andereRegelnButton.setText("Punkte-Regeln");
            } else if (modus == 'k'){
                textArea.setText(p);
                changeModus();
                andereRegelnButton.setText("Karten-Regeln");
            }

        });

        cancelButton.addActionListener(e -> {
            mainFrame.setContent(new Menue(mainFrame));
        });
    }

    private void changeModus(){
        if (modus == 'p'){
            modus = 'k';
        } else modus = 'p';
    }
}
