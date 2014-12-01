package tec;

import tec.EtatPassager;
import tec.Bus;
import tec.CaractereArret;


abstract class PassagerAbstrait implements Passager, Usager {
    protected String nom;
    protected EtatPassager etat;
    protected int destination;
    protected CaractereArret caractere; 

    public PassagerAbstrait(String nom, int destination) {
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

    public void monterDans(Transport b) throws TecInvalidException {
        if (!(b instanceof Bus)) {
            throw new TecInvalidException();
        }
        choixPlaceMontee((Bus) b);
    }

    public void nouvelArret(Bus bus, int numeroArret) {
        if (numeroArret >= this.destination) {
            bus.demanderSortie(this);
        } else {
            caractere.choixChangerPlace(bus, numeroArret, this);
        }
    }

    abstract public void choixPlaceMontee(Bus b);

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
