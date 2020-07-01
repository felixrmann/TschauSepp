package TschauSepp.model;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-Juli-01
 */

public class Modus {
    private int zielPunkte;
    private char modus;

    public Modus(char modus, int zielPunkte){
        this.modus = modus;
        this.zielPunkte = zielPunkte;
    }

    public char getModus() {
        return modus;
    }

    public int getZielPunkte() {
        return zielPunkte;
    }

    public void setZielPunkte(int zielPunkte) {
        this.zielPunkte = zielPunkte;
    }
}
