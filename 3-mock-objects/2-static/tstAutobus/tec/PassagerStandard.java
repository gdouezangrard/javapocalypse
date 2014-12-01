package tec;
import tec.Messages;
import tec.Autobus;

public class PassagerStandard {
    /** passager assis à l'intérieur */  static int	ASSIS  = 0;
    /** passager debout à l'intérieur */ static int	DEBOUT = 1;
    /** passager à l'extérieur */        static int	DEHORS = 2;
    private String nom;
    private int destination;
    // private EtatPassager monEtat;
    public int status;
    public Messages messages;

    public PassagerStandard() {
        this(null, 50);
    }

    public PassagerStandard(String nom, int destination) {
        this.nom = nom;
        this.destination = destination;
        status = DEHORS;
        messages = new Messages();
    }

    public String nom() {
        return null;
    }

    public boolean estDehors() {
        return (status == DEHORS);
    }

    public boolean estAssis() {
        return (status == ASSIS);
    }

    public boolean estDebout() {
        return (status == DEBOUT);
    }

    public void accepterSortie() {
        messages.add("accepterSortie");
    }

    public void accepterPlaceAssise() {
        messages.add("accepterPlaceAssise");
    }

    public void accepterPlaceDebout() {
        messages.add("accepterPlaceDebout");
    }

    public void nouvelArret(Autobus bus, int numeroArret) {
        messages.add("nouvelArret");
    }

    public void monterDans(Autobus t) { 
    }
}
