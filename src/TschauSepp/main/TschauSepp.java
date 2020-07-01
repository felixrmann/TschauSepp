package TschauSepp.main;

import TschauSepp.view.MainFrame;
import TschauSepp.view.Menue;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-Mai-29
 */

public class TschauSepp {
    //TODO alles JUnit testfälle einbauen
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setContent(new Menue(mainFrame));
    }
}
