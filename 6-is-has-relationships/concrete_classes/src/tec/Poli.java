package tec;



public class Poli implements CaractereArret {


    public void choixChangerPlace(Bus b, int numeroArret, PassagerAbstrait p) {
	if (!b.aPlaceAssise()) {
	    b.demanderChangerEnDebout(p);
	}
    }
    
}