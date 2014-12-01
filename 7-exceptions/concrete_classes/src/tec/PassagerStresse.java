package tec;

import tec.Prudent;


final class PassagerStresse extends Fatigue {
    public PassagerStresse (String nom, int destination) {
        super(nom, destination);
	this.caractere = new Prudent();
    }
}
