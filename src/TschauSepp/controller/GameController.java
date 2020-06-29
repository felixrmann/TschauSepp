package TschauSepp.controller;

import TschauSepp.model.Ablagestapel;
import TschauSepp.model.Karte;
import TschauSepp.model.Spieler;
import TschauSepp.view.ExitView;
import TschauSepp.view.GameView;
import TschauSepp.view.MainFrame;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-Juni-28
 */

public class GameController {
    public static void legenButtonController(Spieler currentSpieler, Ablagestapel ablagestapel, Karte legenKarte, GameView gameView){
        String wollenLegenKarteFarbe = legenKarte.getKuerzel().substring(0,2);
        String currentKarteFarbe = ablagestapel.getObersteKarte().getKuerzel().substring(0,2);
        String wollenLegenKarteNummer = legenKarte.getKuerzel().substring(2,4);
        String currentKarteNummer = ablagestapel.getObersteKarte().getKuerzel().substring(2,4);

        if (wollenLegenKarteFarbe.equals(currentKarteFarbe) || wollenLegenKarteNummer.equals(currentKarteNummer)){
            ablagestapel.addKarte(legenKarte);
            currentSpieler.removeKarte(legenKarte);
            gameView.nextSpieler();
        }
    }

    public static void ziehenButtonController(Spieler currentSpieler){

    }

    public static void tschauButtonController(Spieler currentSpieler){

    }

    public static void seppButtonController(Spieler currentSpieler){

    }

    public static void exitButtonController(MainFrame mainFrame){
        new ExitView(mainFrame);
    }
}
