package tec;

import java.util.List;
import java.util.ArrayList;

import tec.JaugeNaturel;
import tec.Passager;

class Autobus implements Bus, Transport {
    private List<Passager> passagers;
    private List<Passager> descendant;
    private int passagersAssis;
    private int passagersDebout;
    private JaugeNaturel assis;
    private JaugeNaturel debout;
    private int numeroArret;

    public Autobus(int assis, int debout) {
        this.assis = new JaugeNaturel(assis, 0);
        this.debout = new JaugeNaturel(debout, 0);
        this.numeroArret = 0;
        this.passagersDebout = 0;
        this.passagersAssis = 0;

        passagers = new ArrayList<Passager>();
        descendant = new ArrayList<Passager>();
    }

    public boolean aPlaceAssise() {
        return assis.estVert();
    }

    public boolean aPlaceDebout() {
        return debout.estVert();
    }

    public void demanderPlaceAssise(Passager p) {
        if (aPlaceAssise() && p.estDehors()) {
            p.accepterPlaceAssise();
            assis.incrementer();
            passagersAssis++;
            passagers.add(p);
        }
    }

    public void demanderPlaceDebout(Passager p) {
        if (aPlaceDebout() && p.estDehors()) {
            p.accepterPlaceDebout();
            debout.incrementer();
            passagersDebout++;
            passagers.add(p);
        }
    }

    public void demanderSortie(Passager p) {
        if (p.estAssis()) {
            assis.decrementer();
            passagersAssis--;
        }
        else if (p.estDebout()) {
            debout.decrementer();
            passagersDebout--;
        }

        p.accepterSortie();
        passagers.remove(p);
        descendant.add(p);
    }

    public void demanderChangerEnDebout(Passager p) {
        if (p.estAssis() && aPlaceDebout()) {
            assis.decrementer();
            passagersAssis--;
            debout.incrementer();
            passagersDebout++;
            p.accepterPlaceDebout();
        }
    }

    public void demanderChangerEnAssis(Passager p) {
        if (p.estDebout() && aPlaceAssise()) {
            debout.decrementer();
            passagersDebout--;
            assis.incrementer();
            passagersDebout++;
            p.accepterPlaceAssise();
        }
    }

    public void allerArretSuivant() {
        numeroArret++;
        for (Passager i : passagers) {
            i.nouvelArret(this, numeroArret);
        }
        for (Passager d : descendant) {
            passagers.remove(d);
        }
        descendant.clear();
    }

    public int distanceA(int numeroArret) {
        return numeroArret - this.numeroArret;
    }

    public String toString() {
        return ("[arret:" + numeroArret +
                ", assis:" + passagersAssis +
                ", debout:" + passagersDebout + "]");
    }
}
