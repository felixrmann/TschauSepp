package TschauSepp.model;

import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-Juni-27
 */

public class Kartenstapel {
    private Vector<Karte> alleKarten;

    public Kartenstapel(){
        alleKarten = new Vector<>();

        addKartenset();
        addKartenset();

        Collections.shuffle(alleKarten);
    }

    public void addKartenset(){
        alleKarten.add(new Karte(getClass().getResource("../img/e_6_.gif"),"e_6_",6));
        alleKarten.add(new Karte(getClass().getResource("../img/e_7_.gif"),"e_7_",7));
        alleKarten.add(new Karte(getClass().getResource("../img/e_8_.gif"),"e_8_",8));
        alleKarten.add(new Karte(getClass().getResource("../img/e_9_.gif"),"e_9_",9));
        alleKarten.add(new Karte(getClass().getResource("../img/e_10.gif"),"e_10",10));
        alleKarten.add(new Karte(getClass().getResource("../img/e_A_.gif"),"e_A_",11));
        alleKarten.add(new Karte(getClass().getResource("../img/e_K_.gif"),"e_K_",4));
        alleKarten.add(new Karte(getClass().getResource("../img/e_O_.gif"),"e_O_",3));
        alleKarten.add(new Karte(getClass().getResource("../img/e_U_.gif"),"e_U_",20));

        alleKarten.add(new Karte(getClass().getResource("../img/r_6_.gif"),"r_6_",6));
        alleKarten.add(new Karte(getClass().getResource("../img/r_7_.gif"),"r_7_",7));
        alleKarten.add(new Karte(getClass().getResource("../img/r_8_.gif"),"r_8_",8));
        alleKarten.add(new Karte(getClass().getResource("../img/r_9_.gif"),"r_9_",9));
        alleKarten.add(new Karte(getClass().getResource("../img/r_10.gif"),"r_10",10));
        alleKarten.add(new Karte(getClass().getResource("../img/r_A_.gif"),"r_A_",11));
        alleKarten.add(new Karte(getClass().getResource("../img/r_K_.gif"),"r_K_",4));
        alleKarten.add(new Karte(getClass().getResource("../img/r_O_.gif"),"r_O_",3));
        alleKarten.add(new Karte(getClass().getResource("../img/r_U_.gif"),"r_U_",20));

        alleKarten.add(new Karte(getClass().getResource("../img/se6_.gif"),"se6_",6));
        alleKarten.add(new Karte(getClass().getResource("../img/se7_.gif"),"se7_",7));
        alleKarten.add(new Karte(getClass().getResource("../img/se8_.gif"),"se8_",8));
        alleKarten.add(new Karte(getClass().getResource("../img/se9_.gif"),"se9_",9));
        alleKarten.add(new Karte(getClass().getResource("../img/se10.gif"),"se10",10));
        alleKarten.add(new Karte(getClass().getResource("../img/seA_.gif"),"seA_",11));
        alleKarten.add(new Karte(getClass().getResource("../img/seK_.gif"),"seK_",4));
        alleKarten.add(new Karte(getClass().getResource("../img/seO_.gif"),"seO_",3));
        alleKarten.add(new Karte(getClass().getResource("../img/seU_.gif"),"seU_",20));

        alleKarten.add(new Karte(getClass().getResource("../img/si6_.gif"),"si6_",6));
        alleKarten.add(new Karte(getClass().getResource("../img/si7_.gif"),"si7_",7));
        alleKarten.add(new Karte(getClass().getResource("../img/si8_.gif"),"si8_",8));
        alleKarten.add(new Karte(getClass().getResource("../img/si9_.gif"),"si9_",9));
        alleKarten.add(new Karte(getClass().getResource("../img/si10.gif"),"si10",10));
        alleKarten.add(new Karte(getClass().getResource("../img/siA_.gif"),"siA_",11));
        alleKarten.add(new Karte(getClass().getResource("../img/siK_.gif"),"siK_",4));
        alleKarten.add(new Karte(getClass().getResource("../img/siO_.gif"),"siO_",3));
        alleKarten.add(new Karte(getClass().getResource("../img/siU_.gif"),"siU_",20));
    }

    public void clearKartenstapel(){
        alleKarten.clear();
    }

    public Karte getKarte(int index){
        return alleKarten.get(index);
    }

    public Karte getRandomKarteAndRemove(){
        int index = (int) (Math.random() * alleKarten.size());
        Karte out = alleKarten.get(index);
        alleKarten.remove(index);
        return out;
    }

    public void removeKarte(int index){
        alleKarten.remove(index);
    }

    public void removeKarte(Karte karte){
        alleKarten.remove(karte);
    }

    public Vector<Karte> getAlleKarten() {
        return alleKarten;
    }

    public boolean hasCards(){
        return !alleKarten.isEmpty();
    }

    public int getAnzKarten(){return alleKarten.size();}

    public void shuffleKartenset(){
        Collections.shuffle(alleKarten);
    }

    public void addAblagestapel(Vector<Karte> ablagestapel){
        alleKarten.addAll(ablagestapel);
    }
}
