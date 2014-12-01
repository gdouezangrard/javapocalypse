package tec;

import tec.TestEtatPassager;
import tec.TestPassagerStandard;
import tec.TestJaugeNaturel;
import tec.TestAutobus;


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

        TestJaugeNaturel tj = new TestJaugeNaturel();
        tj.lancer();

        TestAutobus ta = new TestAutobus();
        ta.lancer();
    }
}
