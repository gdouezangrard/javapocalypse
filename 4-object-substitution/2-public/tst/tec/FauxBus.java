package tec;

import tec.Messages;
import tec.Passager;


public class FauxBus extends Bus implements Transport {
    static byte ASSIS = 1;
    byte status = 1;

    final Messages messages = new Messages();

    FauxBus(int assis, int debout) {
    }

    public boolean aPlaceAssise() {
        return true;
    }

    public boolean aPlaceDebout() {
        return true;
    }

    void demanderPlaceAssise(Passager p) {
        messages.add("demanderPlaceAssise");
    }

    void demanderPlaceDebout(Passager p) {
        messages.add("demanderPlaceDebout");
    }

    void demanderSortie(Passager p) {
        messages.add("demanderSortie");
    }

    void demanderChangerEnDebout(Passager p) {
        messages.add("demanderChangerEnDebout");
    }

    void demanderChangerEnAssis(Passager p) {
        messages.add("demanderChangerEnAssis");
    }

    public void allerArretSuivant() {
        messages.add("allerArretSuivant");
    }
}
