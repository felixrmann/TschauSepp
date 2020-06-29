package TschauSepp.model;

import java.net.URL;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-Mai-29
 */

public class Karte {
    private URL path;
    private String kuerzel;
    private int wert;

    public Karte(URL path, String kuerzel, int wert){
        this.path = path;
        this.kuerzel = kuerzel;
        this.wert = wert;
    }

    public String getKuerzel() {
        return kuerzel;
    }

    public int getWert() {
        return wert;
    }

    public URL getPath(){
        return path;
    }
}
