package tec;


public class Tetu extends PassagerAbstrait {

    public Tetu(String nom, int destination) {
	super(nom, destination);
    }


    public void choixPlaceMontee(Bus b) {
	b.demanderPlaceDebout(this);
    }
}