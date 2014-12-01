package tec;


public class Fatigue extends PassagerAbstrait {

    public Fatigue(String nom, int destination) {
	super(nom, destination);

    }

    public void choixPlaceMontee(Bus b) {
	if (b.aPlaceAssise()) {
	    b.demanderPlaceAssise(this);
	}
    }
}