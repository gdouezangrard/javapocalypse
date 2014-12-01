package tec;

import tec.EtatPassager;
import tec.Bus;


class PassagerStandard implements Passager, Usager {
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

    public boolean estDehors() {
        return etat.estExterieur();
    }

    public boolean estAssis() {
        return etat.estAssis();
    }

    public boolean estDebout() {
        return etat.estDebout();
    }

    public void accepterSortie() {
        etat = etat.dehors();
    }

    public void accepterPlaceAssise() {
        etat = etat.assis();
    }

    public void accepterPlaceDebout() {
        etat = etat.debout();
    }

    public void nouvelArret(Bus bus, int numeroArret) {
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
