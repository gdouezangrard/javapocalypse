package tec;

import tec.Prudent;
import tec.CaractereArret;

final class PassagerStresse extends Fatigue {
    public PassagerStresse (String nom, int destination, CaractereArret c) {
        super(nom, destination);
	caractere = c;
    }
}
