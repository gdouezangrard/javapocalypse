package tec;

import tec.Messages;
import tec.Autobus;


public class FauxPassager implements Passager, Usager {
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

    public FauxPassager(String nom, int destination) {
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

    public void nouvelArret(Bus bus, int numeroArret) {
        messages.add("nouvelArret");
    }

    public void monterDans(Transport t) {
    }
}
