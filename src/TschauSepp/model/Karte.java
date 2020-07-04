package TschauSepp.model;

import java.net.URL;

/**
 * The type Karte.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2020 -Mai-29
 */
public class Karte {
    private URL path;
    private String kuerzel;
    private int wert;

    /**
     * Instantiates a new Karte.
     *
     * @param path    the path
     * @param kuerzel the kuerzel
     * @param wert    the wert
     */
    public Karte(URL path, String kuerzel, int wert){
        this.path = path;
        this.kuerzel = kuerzel;
        this.wert = wert;
    }

    /**
     * Gets kuerzel.
     *
     * @return the kuerzel
     */
    public String getKuerzel() {
        return kuerzel;
    }

    /**
     * Gets wert.
     *
     * @return the wert
     */
    public int getWert() {
        return wert;
    }

    /**
     * Get path url.
     *
     * @return the url
     */
    public URL getPath(){
        return path;
    }
}
