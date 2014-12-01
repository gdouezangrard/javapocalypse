package tec;

import tec.Nerveux;

final class PassagerLunatique extends Sportif {
  
    public PassagerLunatique(String nom, int destination) {
        super(nom, destination);
	this.caractere = new Nerveux();
    }
}
