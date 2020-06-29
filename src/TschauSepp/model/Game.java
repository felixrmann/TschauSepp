package TschauSepp.model;

import TschauSepp.view.GameView;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-Juni-29
 */

public class Game {
    private GameView gameView;

    public Game(GameView gameView){
        this.gameView = gameView;
    }

    public void nextRound(){
        for (int i = 0; i < gameView.getSpielerListe().size(); i++) {
            new Zug(gameView.getSpielerListe().get(i));
        }

    }
}
