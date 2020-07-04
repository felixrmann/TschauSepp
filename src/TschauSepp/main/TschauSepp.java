package TschauSepp.main;

import TschauSepp.view.MainFrame;
import TschauSepp.view.Menue;

/**
 * The type Tschau sepp.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2020 -Mai-29
 */
public class TschauSepp {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setContent(new Menue(mainFrame));
    }
}
