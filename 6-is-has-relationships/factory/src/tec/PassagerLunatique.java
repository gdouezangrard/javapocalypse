package tec;

import tec.Nerveux;
import tec.CaractereArret;

final class PassagerLunatique extends Sportif {
  
    public PassagerLunatique(String nom, int destination, CaractereArret c) {
        super(nom, destination);
	caractere = c;
    }
}
