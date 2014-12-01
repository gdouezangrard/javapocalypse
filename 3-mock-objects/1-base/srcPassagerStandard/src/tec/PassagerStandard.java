package tec;

public class PassagerStandard {
    private String nom;
    private EtatPassager monEtat;
    private int destination;

    public PassagerStandard(String nom, int destination) {
        this.nom = nom;
        this.destination = destination;
        monEtat = new EtatPassager();
    }

    public String nom() {
        return nom;
    }

    public boolean estDehors() {
        return monEtat.estExterieur();
    }

   public boolean estAssis() {
        return monEtat.estAssis();
    }

    public boolean estDebout() {
        return monEtat.estDebout();
    }

    public void accepterSortie() {
        monEtat = monEtat.dehors();
    }

    public void accepterPlaceAssise() {
        monEtat = monEtat.assis();
    }

    public void accepterPlaceDebout() {
        monEtat = monEtat.debout();
    }

    public void nouvelArret(Autobus bus, int numeroArret) {
        if (numeroArret >= this.destination) {
            bus.demanderSortie(this);
        }
    }

    public void monterDans(Autobus t) { 
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
