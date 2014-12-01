package tec;

import tec.EtatPassager;
import tec.Bus;


public class PassagerStandard extends Passager implements Usager {
    private String nom;
    private EtatPassager etat;
    private int destination;

    public PassagerStandard(String nom, int destination) {
        this.nom = nom;
        this.destination = destination;
        etat = EtatPassager.dehors();
    }

    public String nom() {
        return nom;
    }

    boolean estDehors() {
        return etat.estExterieur();
    }

    boolean estAssis() {
        return etat.estAssis();
    }

    boolean estDebout() {
        return etat.estDebout();
    }

    void accepterSortie() {
        etat = etat.dehors();
    }

    void accepterPlaceAssise() {
        etat = etat.assis();
    }

    void accepterPlaceDebout() {
        etat = etat.debout();
    }

    void nouvelArret(Bus bus, int numeroArret) {
        if (numeroArret >= this.destination) {
            bus.demanderSortie(this);
        }
    }

    public void monterDans(Transport b) {
        Bus t = (Bus) b;
        if (t.aPlaceAssise()) {
            t.demanderPlaceAssise(this);
        }

        else if (t.aPlaceDebout()) {
            t.demanderPlaceDebout(this);
        }
    }

    public String toString() {
        String etat = "";

        if (estDehors())
            etat = "dehors";

        else if (estDebout())
            etat = "debout";

        else if (estAssis())
            etat = "assis(e)";


        return nom + " " + etat;
    }
}
