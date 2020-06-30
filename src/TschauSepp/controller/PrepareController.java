package TschauSepp.controller;

import TschauSepp.model.Spieler;
import TschauSepp.view.*;

import java.util.Vector;


/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-Mai-29
 */

public class PrepareController {

    public static void addPlayerButtonController(MainFrame mainFrame, PrepareView prepareView){
        new PlayerCustomizeView(mainFrame, prepareView);
    }

    public static void removePlayerButtonController(PrepareView prepareView, int index){
        prepareView.removeSpieler(index);
    }

    public static void cancelButtonController(MainFrame mainFrame){
        mainFrame.setContent(new Menue(mainFrame));
    }

    public static void playButtonController(MainFrame mainFrame, Vector<Spieler> spielerListe, char modus){
        mainFrame.setFrameSize(900,900);
        mainFrame.setContent(new GameView(mainFrame, spielerListe, modus));
    }
}
