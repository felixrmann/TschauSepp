package TschauSepp.main;

import TschauSepp.model.Spieler;
import TschauSepp.view.GameView;
import TschauSepp.view.MainFrame;

import java.awt.*;
import java.util.Vector;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-Juni-06
 */

public class GameStart {
    //TODO diese Klasse löschen wenn fertig
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        Vector<Spieler> spielerListe = new Vector<>();
        spielerListe.add(new Spieler("Spieler 1", Color.RED));
        spielerListe.add(new Spieler("Spieler 2", Color.BLUE));
        spielerListe.add(new Spieler("Spieler 3", Color.GREEN));
        spielerListe.add(new Spieler("Spieler 4", Color.GRAY));
        spielerListe.add(new Spieler("Spieler 5", Color.CYAN));
        mainFrame.setFrameSize(900,900);
        mainFrame.setContent(new GameView(mainFrame, spielerListe, 'p'));
    }
}
