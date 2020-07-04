package TschauSepp.model;

import java.util.Vector;

/**
 * The type Ablagestapel.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2020 -Juni-29
 */
public class Ablagestapel {
    private final Vector<Karte> alleKarten;

    /**
     * Instantiates a new Ablagestapel.
     */
    public Ablagestapel(){
        alleKarten = new Vector<>();
    }

    /**
     * Add karte.
     *
     * @param karte the karte
     */
    public void addKarte(Karte karte){
        alleKarten.add(karte);
    }

    /**
     * Get oberste karte karte.
     *
     * @return the karte
     */
    public Karte getObersteKarte(){
        return alleKarten.get(alleKarten.size() - 1);
    }

    /**
     * Set oberste karte.
     *
     * @param karte the karte
     */
    public void setObersteKarte(Karte karte){
        alleKarten.add(karte);
    }

    /**
     * Get alle karten and empty vector.
     *
     * @return the vector
     */
    public Vector<Karte> getAlleKartenAndEmpty(){
        Karte tempKar = alleKarten.get(alleKarten.size() -1);
        alleKarten.remove(tempKar);
        Vector<Karte> tempalle = new Vector<>(alleKarten);
        alleKarten.clear();
        alleKarten.add(tempKar);
        return tempalle;
    }


}
