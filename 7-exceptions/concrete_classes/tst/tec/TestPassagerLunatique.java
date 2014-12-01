package tec;

import tec.TestPassagerAbstrait;
import tec.PassagerLunatique;

class TestPassagerLunatique extends TestPassagerAbstrait {
    protected PassagerAbstrait creerPassager(String nom, int destination) {
        return new PassagerLunatique(nom, destination);
    }

    void testChoixChangerPlace() throws TecInvalidException {
        FauxBus bus = new FauxBus(5, 10);
        PassagerAbstrait passager = this.creerPassager("Goliath", 6);
        passager.monterDans(bus);
        passager.accepterPlaceDebout();

        passager.nouvelArret(bus, 0);
        if (passager.estAssis() == true) {
            assert bus.messages.getLast() == "demanderChangerEnDebout";
        } else {
            assert bus.messages.getLast() == "demanderChangerEnAssis";
        }

        passager.nouvelArret(bus, 1);
        if (passager.estDebout() == true) {
            assert bus.messages.getLast() == "demanderChangerEnAssis";
        } else {
            assert bus.messages.getLast() == "demanderChangerEnDebout";
        }
    }

    void testChoixPlaceMontee(FauxBus bus, Passager passager) throws TecInvalidException {
        Usager u = (Usager) passager;
        u.monterDans(bus);
        if (bus.aPlaceAssise() && bus.aPlaceDebout()) {
            assert bus.messages.getLast() == "demanderPlaceDebout";
        } else if (bus.aPlaceAssise() && !bus.aPlaceDebout()) {
            assert bus.messages.getLast() == "demanderPlaceAssise";
        } else if (!bus.aPlaceAssise() && bus.aPlaceDebout()) {
            assert bus.messages.getLast() == "demanderPlaceDebout";
        } else {
            assert bus.messages.size() == 0;
        }
    }
}
