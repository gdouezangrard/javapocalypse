package tec;

import tec.TestPassagerAbstrait;
import tec.PassagerStresse;

class TestPassagerStresse extends TestPassagerAbstrait {
    protected PassagerAbstrait creerPassager(String nom, int destination) {
        return new PassagerStresse(nom, destination);
    }

    void testChoixPlaceMontee(FauxBus bus, Passager passager) {
        Usager u = (Usager) passager;
        u.monterDans(bus);
        if (bus.aPlaceAssise() && bus.aPlaceDebout()) {
            assert bus.messages.getLast() == "demanderPlaceAssise";
        } else if (bus.aPlaceAssise() && !bus.aPlaceDebout()) {
            assert bus.messages.getLast() == "demanderPlaceAssise";
        } else if (!bus.aPlaceAssise() && bus.aPlaceDebout()) {
            assert bus.messages.size() == 0;
        } else {
            assert bus.messages.size() == 0;
        }
    }

    void testChoixChangerPlace() {
        FauxBus bus = new FauxBus(5, 10);
        PassagerAbstrait passager = this.creerPassager("Goliath", 6);
        passager.monterDans(bus);

        passager.nouvelArret(bus, 3);
        assert bus.messages.getLast() == "demanderChangerEnDebout";
    }
}
