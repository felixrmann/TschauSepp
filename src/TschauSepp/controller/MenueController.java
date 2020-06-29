package TschauSepp.controller;

import TschauSepp.view.MainFrame;
import TschauSepp.view.PrepareView;
import TschauSepp.view.RegelnView;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-Mai-29
 */

public class MenueController {
    public static void playButtonController(MainFrame mainFrame){
        mainFrame.setContent(new PrepareView(mainFrame));
    }

    public static void regelnButtonController(MainFrame mainFrame){
        mainFrame.setContent(new RegelnView(mainFrame));
    }

    public static void exitButtonController(){
        System.exit(0);
    }
}
