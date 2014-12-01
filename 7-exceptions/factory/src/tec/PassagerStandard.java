package tec;

import tec.Calme;
import tec.CaractereArret;

final class PassagerStandard extends Repos {
    public PassagerStandard(String nom, int destination, CaractereArret c) {
        super(nom, destination);
	caractere = c;
    }
}
