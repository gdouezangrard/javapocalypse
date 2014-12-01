package tec;


public class Nerveux implements CaractereArret {


    public void choixChangerPlace(Bus b, int numeroArret, PassagerAbstrait p) {
	if(p.estAssis()) {
		    b.demanderChangerEnDebout(p);
	} else if (p.estDebout()) {
	    b.demanderChangerEnAssis(p);
	}
	    }
    
}

