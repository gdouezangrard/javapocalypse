import tec.TestEtatPassager;
import tec.TestJaugeNaturel;

class LancerTests {
    public static void main(String... args) {
        boolean estMisAssertion = false;
        assert estMisAssertion = true;

        if (!estMisAssertion) {
            System.out.println("Execution impossible sans l'option -ea");
            return;
        }

        TestEtatPassager te = new TestEtatPassager();
        te.lancer();

        TestJaugeNaturel tj = new TestJaugeNaturel();
        tj.lancer();
    }
}
