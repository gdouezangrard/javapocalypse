package tec;

import tec.Messages;
import tec.Autobus;


public class FauxPassager extends Passager implements Usager {
    public static int ASSIS  = 0;
    public static int DEBOUT = 1;
    public static int DEHORS = 2;
    private String nom;
    private int destination;

    public int status;
    public Messages messages;

    public FauxPassager() {
        this(null, 50);
    }

    FauxPassager(String nom, int destination) {
        this.nom = nom;
        this.destination = destination;
        status = DEHORS;
        messages = new Messages();
    }

    public String nom() {
        return null;
    }

    boolean estDehors() {
        return (status == DEHORS);
    }

    boolean estAssis() {
        return (status == ASSIS);
    }

    boolean estDebout() {
        return (status == DEBOUT);
    }

    void accepterSortie() {
        messages.add("accepterSortie");
    }

    void accepterPlaceAssise() {
        messages.add("accepterPlaceAssise");
    }

    void accepterPlaceDebout() {
        messages.add("accepterPlaceDebout");
    }

    void nouvelArret(Bus bus, int numeroArret) {
        messages.add("nouvelArret");
    }

    public void monterDans(Transport t) {
    }
}
