package TschauSepp.view;

import TschauSepp.model.Spieler;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The type End view.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2020 -Juli-01
 */
public class EndView extends JPanel {

    private JPanel mainPanel, midPanel;
    private JLabel topLabel, gewinnerLabel;
    private Spieler gewinner;


    /**
     * Instantiates a new End view.
     *
     * @param mainFrame the main frame
     * @param gewinner  the gewinner
     */
    public EndView(MainFrame mainFrame, Spieler gewinner){
        this.gewinner = gewinner;

        mainPanel = new JPanel();
        midPanel = new JPanel();
        topLabel = new JLabel();
        gewinnerLabel = new JLabel();

        init();

        java.util.Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                mainFrame.setContent(new Menue(mainFrame));
            }
        }, 3000);
    }

    private void init() {
        add(mainPanel);

        mainPanel.setBackground(new Color(30,87,216));
        midPanel.setBackground(new Color(30,87,216));

        mainPanel.setLayout(new BorderLayout(10,10));
        mainPanel.setPreferredSize(new Dimension(386, 458));
        mainPanel.add(topLabel, BorderLayout.NORTH);
        mainPanel.add(midPanel, BorderLayout.CENTER);

        topLabel.setText("Der Gewinner ist:");
        topLabel.setFont(new Font(topLabel.getFont().getName(), Font.PLAIN, 30));

        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(30,87,216));
        midPanel.setLayout(new BorderLayout());
        midPanel.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));
        midPanel.add(gewinnerLabel, BorderLayout.CENTER);
        midPanel.add(panel1, BorderLayout.SOUTH);

        gewinnerLabel.setText(gewinner.getName());
        gewinnerLabel.setFont(new Font(topLabel.getFont().getName(), Font.PLAIN, 40));
        gewinnerLabel.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
    }
}
