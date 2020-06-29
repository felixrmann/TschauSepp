package TschauSepp.model;

import java.awt.*;
import java.util.Vector;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-Mai-29
 */

public class Spieler {
    private String name;
    private Color farbe;
    private Vector<Karte> handkarten;
    private int punktestand;

    public Spieler(String name, Color farbe){
        this.name = name;
        this.farbe = farbe;

        handkarten = new Vector<>();
    }

    public String getName() {
        return name;
    }

    public Color getFarbe() {
        return farbe;
    }

    public void addKarte(Karte karte){
        handkarten.add(karte);
    }

    public void removeKarte(Karte karte){
        handkarten.remove(karte);
    }

    public void addPunkte(int amount){
        punktestand += amount;
    }

    public int getPunktestand() {
        return punktestand;
    }

    public boolean isTschau(){
        return handkarten.size() <= 2;
    }

    public boolean isSepp(){
        return handkarten.size() <= 1;
    }

    public Vector<Karte> getHandkarten(){
        return handkarten;
    }
}
