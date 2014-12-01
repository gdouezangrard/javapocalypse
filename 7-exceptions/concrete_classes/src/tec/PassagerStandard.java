package tec;

import tec.Calme;


final class PassagerStandard extends Repos {
    public PassagerStandard(String nom, int destination) {
        super(nom, destination);
	caractere = new Calme();
    }
}
