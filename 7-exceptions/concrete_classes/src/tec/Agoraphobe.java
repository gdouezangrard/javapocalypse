package tec;



public class Agoraphobe implements CaractereArret {


    public void choixChangerPlace(Bus b, int numeroArret, PassagerAbstrait p) {
	if(!b.aPlaceAssise() && !b.aPlaceDebout())
	    b.demanderSortie(p);
    }
    
    
}