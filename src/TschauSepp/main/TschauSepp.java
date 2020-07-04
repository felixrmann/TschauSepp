package TschauSepp.main;

import TschauSepp.view.AuswahlView;
import TschauSepp.view.MainFrame;
import TschauSepp.view.Menue;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-Mai-29
 */

public class TschauSepp {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setContent(new Menue(mainFrame));
    }
}
