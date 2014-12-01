package tec;


public class Repos extends PassagerAbstrait {

    public Repos(String nom, int destination) {
	super(nom, destination);
    }
 


    public void choixPlaceMontee(Bus b) {
	if (b.aPlaceAssise()) {
	    b.demanderPlaceAssise(this);
	} else if (b.aPlaceDebout()) {
	    b.demanderPlaceDebout(this);
	}
    }
}