package TschauSepp.controller;

import TschauSepp.model.Ablagestapel;
import TschauSepp.model.Karte;
import TschauSepp.model.Kartenstapel;
import TschauSepp.model.Spieler;
import TschauSepp.view.ExitView;
import TschauSepp.view.GameView;
import TschauSepp.view.MainFrame;

import java.util.Timer;
import java.util.TimerTask;

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
            gameView.paintCurrentPlayerCards();
            gameView.loadAblagestapel();
            gameView.loadNetxtPlayerPanel();
        }
        //TODO spezielle karten
    }

    public static void ziehenButtonController(Spieler currentSpieler, Kartenstapel kartenstapel, Ablagestapel ablagestapel, GameView gameView){
        String ablageStapelKarteFarbe = ablagestapel.getObersteKarte().getKuerzel().substring(0,2);
        String ablageStapelKarteNummer = ablagestapel.getObersteKarte().getKuerzel().substring(2,4);

        boolean check = true;

        for (int i = 0; i < currentSpieler.getHandkarten().size(); i++) {
            if (ablageStapelKarteFarbe.equals(currentSpieler.getHandkarten().get(i).getKuerzel().substring(0, 2))){
                check = false;
            } else if (ablageStapelKarteNummer.equals(currentSpieler.getHandkarten().get(i).getKuerzel().substring(2, 4))){
                check = false;
            }
        }

        if (check){
            currentSpieler.addKarte(kartenstapel.getRandomKarteAndRemove());
            gameView.paintCurrentPlayerCards();
            gameView.setDisabled();

            java.util.Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    boolean check = true;
                    for (int i = 0; i < currentSpieler.getHandkarten().size(); i++) {
                        if (ablageStapelKarteFarbe.equals(currentSpieler.getHandkarten().get(i).getKuerzel().substring(0, 2))){
                            check = false;
                        } else if (ablageStapelKarteNummer.equals(currentSpieler.getHandkarten().get(i).getKuerzel().substring(2, 4))){
                            check = false;
                        }
                    }
                    if (check) {
                        gameView.nextSpieler();
                        gameView.paintCurrentPlayerCards();
                    }
                }
            }, 2000);
        } else {
            gameView.setMessageLabelNochLegen();
        }
    }

    public static void tschauButtonController(Spieler currentSpieler){
        //TODO Tschau
    }

    public static void seppButtonController(Spieler currentSpieler){
        //TODO Sepp
    }

    public static void exitButtonController(MainFrame mainFrame){
        new ExitView(mainFrame);
    }
}
