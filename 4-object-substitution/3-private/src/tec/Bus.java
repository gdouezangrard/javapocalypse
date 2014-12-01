package tec;

import tec.Passager;

public interface Bus {
    public boolean aPlaceAssise();
    public boolean aPlaceDebout();

    public void demanderPlaceAssise(Passager p);
    public void demanderPlaceDebout(Passager p);
    public void demanderSortie(Passager p);

    public void demanderChangerEnDebout(Passager p);
    public void demanderChangerEnAssis(Passager p);
}
