package TschauSepp.controller;

import TschauSepp.model.Modus;
import TschauSepp.model.Spieler;
import TschauSepp.view.*;

import java.util.Vector;


/**
 * The type Prepare controller.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2020 -Mai-29
 */
public class PrepareController {

    /**
     * Add player button controller.
     *
     * @param mainFrame   the main frame
     * @param prepareView the prepare view
     */
    public static void addPlayerButtonController(MainFrame mainFrame, PrepareView prepareView){
        new PlayerCustomizeView(mainFrame, prepareView);
    }

    /**
     * Remove player button controller.
     *
     * @param prepareView the prepare view
     * @param index       the index
     */
    public static void removePlayerButtonController(PrepareView prepareView, int index){
        prepareView.removeSpieler(index);
    }

    /**
     * Cancel button controller.
     *
     * @param mainFrame the main frame
     */
    public static void cancelButtonController(MainFrame mainFrame){
        mainFrame.setContent(new Menue(mainFrame));
    }

    /**
     * Play button controller.
     *
     * @param mainFrame    the main frame
     * @param spielerListe the spieler liste
     * @param modus        the modus
     */
    public static void playButtonController(MainFrame mainFrame, Vector<Spieler> spielerListe, Modus modus){
        mainFrame.setFrameSize(900,900);
        mainFrame.setContent(new GameView(mainFrame, spielerListe, modus));
    }
}
