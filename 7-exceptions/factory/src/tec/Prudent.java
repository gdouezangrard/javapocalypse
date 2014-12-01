package tec;



public class Prudent implements CaractereArret {


    public void choixChangerPlace(Bus b, int numeroArret, PassagerAbstrait p) {
	if (numeroArret+5 <= p.destination) {
	    b.demanderChangerEnAssis(p);
	}
	else if (numeroArret+3 >= p.destination) {
	    b.demanderChangerEnDebout(p);
	}
    }
    
}