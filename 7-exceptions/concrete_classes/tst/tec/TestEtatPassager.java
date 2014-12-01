package tec;
import tec.EtatPassager;

public class TestEtatPassager{
    private void testExterieur(){
        EtatPassager dh = EtatPassager.dehors();
        assert dh.estAssis() == false;
        assert dh.estDebout() == false;
        assert dh.estExterieur();
        assert dh.estInterieur() == false;
    }
    private void testAssis(){
        EtatPassager dh = EtatPassager.dehors();
        EtatPassager as = dh.assis();
        assert as.estAssis();
        assert as.estDebout() == false;
        assert as.estExterieur() == false;
        assert as.estInterieur();
    }
    private void testDebout(){
        EtatPassager dh = EtatPassager.dehors();
        EtatPassager de = dh.debout();
        assert de.estAssis() == false;
        assert de.estDebout();
        assert de.estExterieur() == false;
        assert de.estInterieur();
    }
    public void lancer(){
        System.out.println(getClass().getName());
        int i = 0;

        System.out.print('.');
        this.testExterieur(); i++;

        System.out.print('.');
        this.testAssis(); i++;

        System.out.print('.');
        this.testDebout(); i++;

        System.out.println(" OK (" + i + "/3)");
    }
}
