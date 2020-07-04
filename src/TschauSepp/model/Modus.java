package TschauSepp.model;

/**
 * The type Modus.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2020 -Juli-01
 */
public class Modus {
    private int zielPunkte;
    private char modus;

    /**
     * Instantiates a new Modus.
     *
     * @param modus      the modus
     * @param zielPunkte the ziel punkte
     */
    public Modus(char modus, int zielPunkte){
        this.modus = modus;
        this.zielPunkte = zielPunkte;
    }

    /**
     * Gets modus.
     *
     * @return the modus
     */
    public char getModus() {
        return modus;
    }

    /**
     * Gets ziel punkte.
     *
     * @return the ziel punkte
     */
    public int getZielPunkte() {
        return zielPunkte;
    }

    /**
     * Sets ziel punkte.
     *
     * @param zielPunkte the ziel punkte
     */
    public void setZielPunkte(int zielPunkte) {
        this.zielPunkte = zielPunkte;
    }
}
