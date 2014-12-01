package tec;

import tec.PassagerAbstrait;
import tec.CaractereArret;
import tec.PassagerStandard;
import tec.PassagerLunatique;
import tec.PassagerStresse;
import tec.Calme;
import tec.Prudent;
import tec.Nerveux;


public abstract class FabriqueTec {
    private FabriqueTec() {
    }

    public static PassagerAbstrait fairePassagerStandard(String nom, int destination) {
	CaractereArret c = new Calme();
        return new PassagerStandard(nom, destination, c);
    }

    public static PassagerAbstrait fairePassagerStresse(String nom, int destination) {
	CaractereArret c = new Prudent();
        return new PassagerStresse(nom, destination, c);
    }
    public static PassagerAbstrait fairePassagerLunatique(String nom, int destination) {
	CaractereArret c = new Nerveux();
        return new PassagerLunatique(nom, destination, c);
    }
}
