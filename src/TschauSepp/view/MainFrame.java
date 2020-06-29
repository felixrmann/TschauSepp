package TschauSepp.view;

import javax.swing.*;

/**
 * The type Main frame.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2020 -Mai-30
 */
public class MainFrame extends JFrame {
    /**
     * Instantiates a new Main frame.
     */
    public MainFrame(){
        setSize(400,500);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Tschau Sepp");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Set content.
     *
     * @param panel the panel
     */
    public void setContent(JPanel panel){
        getContentPane().removeAll();
        setContentPane(panel);
        revalidate();
        repaint();
    }

    /**
     * Set frame size.
     *
     * @param width  the width
     * @param height the height
     */
    public void setFrameSize(int width, int height){
        setSize(width, height);
        setLocationRelativeTo(null);
    }
}
