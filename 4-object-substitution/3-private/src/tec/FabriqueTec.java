package tec;

import tec.PassagerStandard;
import tec.Autobus;
import tec.Bus;
import tec.Passager;


public abstract class FabriqueTec {
    private FabriqueTec() {
    }

    public static Usager fairePassagerStandard(String nom, int destination) {
        return new PassagerStandard(nom, destination);
    }

    public static Transport faireAutobus(int assis, int debout) {
        return new Autobus(assis, debout);
    }
}
