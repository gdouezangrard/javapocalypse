package tec;


public class Sportif extends PassagerAbstrait {

    public Sportif(String nom, int destination) {
	super(nom, destination);
	
    }


    public void choixPlaceMontee(Bus b) {
	if (b.aPlaceDebout()) {
	    b.demanderPlaceDebout(this);
	} else if (b.aPlaceAssise()) {
	    b.demanderPlaceAssise(this);
	}
    }
}