package tec;

import tec.FauxPassager;
import tec.Autobus;

public class TestAutobus {
    void testInstanciation() {
        Autobus a = new Autobus (50, 0);
        assert a.aPlaceAssise() == true;
        assert a.aPlaceDebout() == false;

        a = new Autobus (0, 50);
        assert a.aPlaceAssise() == false;
        assert a.aPlaceDebout() == true;
    }

    /*
     * Remplir toutes les places assises d'un autobus.
     * Remplir toutes les places debout d'un autobus.
     * Demander la sortie.
     */
    void testDemander() {
        FauxPassager[] faux = {null,
            new FauxPassager(),
            new FauxPassager(),
            new FauxPassager(),
            new FauxPassager(),
            new FauxPassager(),
            new FauxPassager(),
            new FauxPassager(),
            new FauxPassager(),
            new FauxPassager()}; //9

        Autobus bus = new Autobus(5, 3);


        for (int i = 1; i <= 5; i++) {
            bus.demanderPlaceAssise(faux[i]);

            // test etat.
            if (i == 5)
                assert false == bus.aPlaceAssise() : "fin assis";
            else
                assert true == bus.aPlaceAssise() : "demande " + i;
        }

        // test interaction.
        for (int i = 1; i <= 5; i++) {
            assert 1 == faux[i].messages.size() : "faux " + i;
            assert "accepterPlaceAssise" == faux[i].messages.getLast()
                : "message " + i;
        }

        for (int i = 6; i <= 8; i++) {
            bus.demanderPlaceDebout(faux[i]);

            // test etat.
            if (i == 8)
                assert false == bus.aPlaceDebout() : "fin debout";
            else
                assert true == bus.aPlaceDebout() : "demande " + i;	
        }

        // test interaction.
        for (int i = 6; i <= 8; i++) {
            assert "accepterPlaceDebout" == faux[i].messages.getLast() 
                : "message " + i;
        }

        bus.demanderSortie(faux[1]);
        bus.demanderSortie(faux[8]);

        // test etat.
        assert false == bus.aPlaceDebout() : "non dispo debout";
        assert false == bus.aPlaceAssise() : "non dispo assis ";

        // test interaction.
        assert "accepterSortie" == faux[1].messages.getLast() : "message 1";
        assert "accepterSortie" == faux[8].messages.getLast() : "message 8";
    }

    void testArretSuivantException() {
        class AnonymousPassager implements Passager {
            public String nom() {return "Ninja";}
            public boolean estDehors() {return true;}
            public boolean estAssis() {return true;}
            public boolean estDebout() {return true;}
            public void accepterSortie() {}
            public void accepterPlaceAssise() {}
            public void accepterPlaceDebout() {}
            public void nouvelArret(Bus b, int numeroArret) {
                throw new IllegalStateException();
            }
        }
        Autobus bus = new Autobus(5,3);
        Passager passager = new AnonymousPassager();
        bus.demanderPlaceAssise(passager);

        try {
            bus.allerArretSuivant();
            assert false : "Exception not thrown";
        } catch (TecInvalidException e) {
        }
    }

    /*
     * Quelques places assises et quelques places debout.
     * Faire sortir un assis et un debout.
     */
    void testArret() throws TecInvalidException {
        FauxPassager[] faux = {null,
            new FauxPassager(),
            new FauxPassager(),
            new FauxPassager(),
            new FauxPassager(),
            new FauxPassager(),
            new FauxPassager(),
            new FauxPassager(),
            new FauxPassager(),
            new FauxPassager()}; //9

        Autobus bus = new Autobus(5, 3);

        bus.demanderPlaceAssise(faux[1]);
        bus.demanderPlaceAssise(faux[2]);
        bus.demanderPlaceDebout(faux[8]);

        // test interaction.
        assert "accepterPlaceAssise" == faux[1].messages.getLast() : "message 1";
        assert "accepterPlaceAssise" == faux[2].messages.getLast() : "message 2";
        assert "accepterPlaceDebout" == faux[8].messages.getLast() : "message 8";

        bus.allerArretSuivant();

        bus.demanderSortie(faux[1]);
        bus.demanderSortie(faux[8]);

        // test interaction.
        assert "accepterSortie" == faux[1].messages.getLast() : "message 1";
        assert "accepterSortie" == faux[8].messages.getLast() : "message 8";
    }

    /*
     * Changer un assis en debout
     * Changer un debout en assis
     */
    void testChanger() {
        FauxPassager[] faux = {null,
            new FauxPassager(),
            new FauxPassager(),
            new FauxPassager(),
            new FauxPassager(),
            new FauxPassager(),
            new FauxPassager(),
            new FauxPassager(),
            new FauxPassager(),
            new FauxPassager()}; //9

        Autobus bus = new Autobus(5, 3);

        for (int i = 1; i <= 5; i++)
            bus.demanderPlaceAssise(faux[i]);

        for (int i = 6; i < 8; i++)
            bus.demanderPlaceDebout(faux[i]);

        bus.demanderChangerEnDebout(faux[1]);

        // test interaction.
        //assert "accepterPlaceDebout" == faux[1].messages.getLast() : "message 1";

        bus.demanderChangerEnAssis(faux[7]);

        // test interaction.
        //assert "accepterPlaceAssise" == faux[7].messages.getLast() : "message 7";
    }

    void testFaussaire() {
        FauxPassager f = new FauxPassager("Georgy", 3);

        f.status = FauxPassager.DEBOUT;

        assert 0 == f.messages.size();

        f.nouvelArret(null, -999);

        assert "nouvelArret" == f.messages.getLast();
    }

    public void lancer() throws TecInvalidException {
        System.out.println(getClass().getName());

        int nbTest = 0;

        System.out.print('.'); nbTest++;
        testFaussaire();

        System.out.print('.'); nbTest++;
        testInstanciation();

        System.out.print('.'); nbTest++;
        testDemander();

        System.out.print('.'); nbTest++;
        testArret();

        System.out.print('.'); nbTest++;
        testChanger();

        System.out.print('.'); nbTest++;
        testArretSuivantException();

        System.out.println("OK (" + nbTest + "/6)");
    }
}
