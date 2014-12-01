package tec;

import tec.Messages;
import tec.Passager;


public class FauxBus implements Bus, Transport {
    boolean places_assises = true;
    boolean places_debout = true;
    int distance = 0;

    public final Messages messages = new Messages();

    public FauxBus(int assis, int debout) {
    }

    public FauxBus(boolean places_assises, boolean places_debout) {
        this.places_assises = places_assises;
        this.places_debout = places_debout;
    }

    public boolean aPlaceAssise() {
        return this.places_assises;
    }

    public boolean aPlaceDebout() {
        return this.places_debout;
    }

    public void demanderPlaceAssise(Passager p) {
        messages.add("demanderPlaceAssise");
    }

    public void demanderPlaceDebout(Passager p) {
        messages.add("demanderPlaceDebout");
    }

    public void demanderSortie(Passager p) {
        messages.add("demanderSortie");
    }

    public void demanderChangerEnDebout(Passager p) {
        messages.add("demanderChangerEnDebout");
    }

    public void demanderChangerEnAssis(Passager p) {
        messages.add("demanderChangerEnAssis");
    }

    public void allerArretSuivant() {
        messages.add("allerArretSuivant");
    }

    public int distanceA(int numeroArret) {
        messages.add("distanceA");
        return numeroArret - distance;
    }
}
