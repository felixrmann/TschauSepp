package TschauSepp.model;

import java.util.Vector;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-Juni-29
 */

public class Ablagestapel {
    private final Vector<Karte> alleKarten;

    public Ablagestapel(){
        alleKarten = new Vector<>();
    }

    public void addKarte(Karte karte){
        alleKarten.add(karte);
    }

    public Karte getObersteKarte(){
        return alleKarten.get(alleKarten.size() - 1);
    }

    public Vector<Karte> getAlleKartenAndEmpty(){
        Vector<Karte> temp;
        temp = alleKarten;
        alleKarten.clear();
        return temp;
    }
}
