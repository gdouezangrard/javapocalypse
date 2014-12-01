package tec;

import tec.PassagerStandard;
import tec.FauxBus;


public class TestPassagerStandard {
    void testFaussaire() {
        FauxBus f = new FauxBus(5, 6);
        f.status = FauxBus.ASSIS;

        assert 0 == f.messages.size();

        f.demanderChangerEnDebout(null);

        assert "demanderChangerEnDebout" == f.messages.getLast();
    }

    void testEtat() {
        PassagerStandard passager = new PassagerStandard("Goliath", 4);

        passager.accepterPlaceAssise();
        assert (passager.estAssis() == true) : "accepterPlaceAssis";

        passager.accepterPlaceDebout();
        assert (passager.estDebout() == true) : "accepterPlaceDebout";

        passager.accepterSortie();
        assert (passager.estDehors() == true) : "accepterSortie";
    }


    void testMonter() {
        FauxBus bus = new FauxBus(5, 10);
        PassagerStandard passager = new PassagerStandard("Goliath", 3);

        passager.monterDans(bus);
        assert bus.messages.getLast() == "demanderPlaceAssise"
            || bus.messages.getLast() == "demanderPlaceDebout";
    }


    void testArret() {
        FauxBus bus = new FauxBus(5, 10);
        PassagerStandard passager = new PassagerStandard("Goliath", 3);

        passager.nouvelArret(bus, 6);
        assert bus.messages.getLast() == "demanderSortie";
    }

    public void lancer() {
        System.out.println(getClass().getName());

        int nbTest = 0;

        System.out.print('.'); nbTest++;
        testFaussaire();

        System.out.print('.'); nbTest++;
        testEtat();

        System.out.print('.'); nbTest++;
        testArret();

        System.out.print('.'); nbTest++;
        testMonter();

        System.out.println(" OK (" + nbTest + "/4)"); 
    }
}
