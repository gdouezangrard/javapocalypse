package tec;
import tec.PassagerStandard;
import tec.Autobus;

public class TestPassagerStandard {
    void testFaussaire() {
        Autobus f = new Autobus(5, 6);
        f.status = Autobus.ASSIS;

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
        Autobus bus = new Autobus(5, 10);
        PassagerStandard passager = new PassagerStandard("Goliath", 3);

        passager.monterDans(bus);
        assert bus.messages.getLast() == "demanderPlaceAssise"
            || bus.messages.getLast() == "demanderPlaceDebout";
    }


    void testArret() {
        Autobus bus = new Autobus(5, 10);
        PassagerStandard passager = new PassagerStandard("Goliath", 3);

        passager.nouvelArret(bus, 6);
        assert bus.messages.getLast() == "demanderSortie";
    }


    public void lancer() {
        int nbTest = 0;

        System.out.print('.'); nbTest++;
        testFaussaire();
        System.out.print('.'); nbTest++;
        testArret();
        System.out.print('.'); nbTest++;
        testMonter();

        System.out.println(nbTest + " : OK " + getClass().getName()); 
    }
}
