package tec;

import tec.TestPassagerAbstrait;
import tec.PassagerStandard;
import tec.FabriqueTec;

class TestPassagerStandard extends TestPassagerAbstrait {
    protected PassagerAbstrait creerPassager(String nom, int destination) {
        return FabriqueTec.fairePassagerStandard(nom, destination);
    }

    void testChoixPlaceMontee(FauxBus bus, Passager passager) {
        Usager u = (Usager) passager;
        u.monterDans(bus);
        if (bus.aPlaceAssise() && bus.aPlaceDebout()) {
            assert bus.messages.getLast() == "demanderPlaceAssise" | bus.messages.getLast() == "demanderPlaceDebout";
        } else if (bus.aPlaceAssise() && !bus.aPlaceDebout()) {
            assert bus.messages.getLast() == "demanderPlaceAssise";
        } else if (!bus.aPlaceAssise() && bus.aPlaceDebout()) {
            assert bus.messages.getLast() == "demanderPlaceDebout";
        } else {
            assert bus.messages.size() == 0;
        }
    }

    void testChoixChangerPlace() {
        FauxBus bus = new FauxBus(5, 10);
        PassagerAbstrait passager = this.creerPassager("Goliath", 6);

        passager.nouvelArret(bus, 0);
        assert bus.messages.size() == 0;

        passager.nouvelArret(bus, 3);
        assert bus.messages.size() == 0;
    }
}
