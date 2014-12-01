package tec;

import tec.Messages;
import tec.Passager;


public class FauxBus implements Bus, Transport {
    static byte ASSIS = 1;
    byte status = 1;

    final Messages messages = new Messages();

    public FauxBus(int assis, int debout) {
    }

    public boolean aPlaceAssise() {
        return true;
    }

    public boolean aPlaceDebout() {
        return true;
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
}
