package TschauSepp.model;

import java.awt.*;
import java.util.Vector;

/**
 * The type Spieler.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2020 -Mai-29
 */
public class Spieler {
    private String name;
    private Color farbe;
    private Vector<Karte> handkarten;
    private int punktestand;
    private boolean tschau, sepp;

    /**
     * Instantiates a new Spieler.
     *
     * @param name  the name
     * @param farbe the farbe
     */
    public Spieler(String name, Color farbe){
        this.name = name;
        this.farbe = farbe;

        tschau = false;
        sepp = false;

        handkarten = new Vector<>();
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets farbe.
     *
     * @return the farbe
     */
    public Color getFarbe() {
        return farbe;
    }

    /**
     * Add karte.
     *
     * @param karte the karte
     */
    public void addKarte(Karte karte){
        handkarten.add(karte);
    }

    /**
     * Remove karte.
     *
     * @param karte the karte
     */
    public void removeKarte(Karte karte){
        handkarten.remove(karte);
    }

    /**
     * Add punkte.
     *
     * @param amount the amount
     */
    public void addPunkte(int amount){
        punktestand += amount;
    }

    /**
     * Gets punktestand.
     *
     * @return the punktestand
     */
    public int getPunktestand() {
        return punktestand;
    }

    /**
     * Is tschau boolean.
     *
     * @return the boolean
     */
    public boolean isTschau(){
        return handkarten.size() == 2;
    }

    /**
     * Is sepp boolean.
     *
     * @return the boolean
     */
    public boolean isSepp(){
        return handkarten.size() == 1;
    }

    /**
     * Get handkarten vector.
     *
     * @return the vector
     */
    public Vector<Karte> getHandkarten(){
        return handkarten;
    }

    /**
     * Get tschau boolean.
     *
     * @return the boolean
     */
    public boolean getTschau(){
        return tschau;
    }

    /**
     * Get sepp boolean.
     *
     * @return the boolean
     */
    public boolean getSepp(){
        return sepp;
    }

    /**
     * Sets tschau.
     *
     * @param tschau the tschau
     */
    public void setTschau(boolean tschau) {
        this.tschau = tschau;
    }

    /**
     * Sets sepp.
     *
     * @param sepp the sepp
     */
    public void setSepp(boolean sepp) {
        this.sepp = sepp;
    }
}
