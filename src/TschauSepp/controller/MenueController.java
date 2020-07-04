package TschauSepp.controller;

import TschauSepp.view.MainFrame;
import TschauSepp.view.PrepareView;
import TschauSepp.view.RegelnView;

/**
 * The type Menue controller.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2020 -Mai-29
 */
public class MenueController {
    /**
     * Play button controller.
     *
     * @param mainFrame the main frame
     */
    public static void playButtonController(MainFrame mainFrame){
        mainFrame.setContent(new PrepareView(mainFrame));
    }

    /**
     * Regeln button controller.
     *
     * @param mainFrame the main frame
     */
    public static void regelnButtonController(MainFrame mainFrame){
        mainFrame.setContent(new RegelnView(mainFrame));
    }

    /**
     * Exit button controller.
     */
    public static void exitButtonController(){
        System.exit(0);
    }
}
