package tec;
import tec.Messages;
import tec.PassagerStandard;

public class Autobus {
    static byte ASSIS = 1;
    byte status = 1;

    final Messages messages = new Messages();

    public Autobus(int assis, int debout) {
    }

    public boolean aPlaceAssise() {
        return true;
    }

    public boolean aPlaceDebout() {
        return true;
    }

    public void demanderPlaceAssise(PassagerStandard p) {
        messages.add("demanderPlaceAssise");
    }

    public void demanderPlaceDebout(PassagerStandard p) {
        messages.add("demanderPlaceDebout");
    }

    public void demanderSortie(PassagerStandard p) {
        messages.add("demanderSortie");
    }

    public void demanderChangerEnDebout(PassagerStandard p) {
        messages.add("demanderChangerEnDebout");
    }

    public void demanderChangerEnAssis(PassagerStandard p) {
        messages.add("demanderChangerEnAssis");
    }

    public void allerArretSuivant() { 
        messages.add("allerArretSuivant");
    }
}
