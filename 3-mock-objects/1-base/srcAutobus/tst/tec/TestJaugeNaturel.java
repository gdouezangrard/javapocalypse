package tec;
import tec.JaugeNaturel;

public class TestJaugeNaturel {
    private JaugeNaturel jauge;

    public TestJaugeNaturel() {
    }

    public void lancer() {
        System.out.println("Test JaugeNaturel");
        int i = 0;
        this.testDansIntervalle();
        System.out.println(".");
        i++;
        this.testDepartSuperieurVigie();
        System.out.println(".");
        i++;
        this.testDepartEgalVigie();
        System.out.println(".");
        i++;
        this.testDepartNegatif();
        System.out.println(".");
        i++;
        this.testDepartZero();
        System.out.println(".");
        i++;
        this.testIncrementer();
        System.out.println(".");
        i++;
        this.testDecrementer();
        i++;
        System.out.println("OK " + i + "/7");
    }

    public void testDansIntervalle() {
        this.newJaugeNaturel(5, 4);
        this.testCouleur(true, false, false);
    }

    public void testDepartSuperieurVigie() {
        this.newJaugeNaturel(5, 6);
        this.testCouleur(false, false, true);
    }

    public void testDepartEgalVigie() {
        this.newJaugeNaturel(5, 5);
        this.testCouleur(false, false, true);
    }

    public void testDepartNegatif() {
        this.newJaugeNaturel(5, -1);
        this.testCouleur(false, true, false);
    }

    public void testDepartZero() {
        this.newJaugeNaturel(5, 0);
        this.testCouleur(true, true, false);
    }

    public void testIncrementer() {
        this.newJaugeNaturel(-1, 2);
        this.testDepartNegatif();

        this.incrementer();
        this.testDepartZero();

        this.incrementer();
        this.testDansIntervalle();

        this.incrementer();
        this.testDepartEgalVigie();

        this.incrementer();
        this.testDepartSuperieurVigie();
    }

    public void testDecrementer() {
        this.newJaugeNaturel(3, 2);
        this.testDepartSuperieurVigie();

        this.decrementer();
        this.testDepartEgalVigie();

        this.decrementer();
        this.testDansIntervalle();

        this.decrementer();
        this.testDepartZero();

        this.decrementer();
        this.testDepartNegatif();
    }

    private void incrementer() {
        this.jauge.incrementer();
    }

    private void decrementer() {
        this.jauge.decrementer();
    }

    private void newJaugeNaturel(int maxVigie, int depart) {
        this.jauge = new JaugeNaturel(maxVigie, depart);
    }

    private void testCouleur(boolean vert, boolean bleu, boolean rouge) {
        assert this.jauge.estVert() == vert;
        assert this.jauge.estBleu() == bleu;
        assert this.jauge.estRouge() == rouge;
    }
}
