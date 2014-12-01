import tec.TestAutobus;
import tec.TestJaugeNaturel;


class LancerTests {
    public static void main(String... args) {
        boolean estMisAssertion = false;
        assert estMisAssertion = true;

        if (!estMisAssertion) {
            System.out.println("Execution impossible sans l'option -ea");
            return;
        }

        TestJaugeNaturel tj = new TestJaugeNaturel();
        tj.lancer();

        TestAutobus ta = new TestAutobus();
        ta.lancer();
    }
}
