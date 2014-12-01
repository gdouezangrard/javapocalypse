import tec.TestEtatPassager;
import tec.TestPassagerStandard;

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

        TestPassagerStandard tp = new TestPassagerStandard();
        tp.lancer();
    }
}
