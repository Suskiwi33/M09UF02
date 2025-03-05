public class Barri {
    private Estanc estanc;
    private Fumador[] fumadors = new Fumador[3];

    public Barri() {
        this.estanc = new Estanc();

        for (int i=0; i<fumadors.length; i++) {
            fumadors[i] = new Fumador(estanc, i);
        }
    }

    public void obreEstanc() {
        estanc.start();
    }

    public void despertaFumadors() {
        for (int i=0; i<fumadors.length; i++) {
            fumadors[i].start();
        }
    }

    public boolean tancarEstanc() {
        if (!fumadors[0].isAlive() && !fumadors[1].isAlive() && !fumadors[2].isAlive()) {
            estanc.tancarEstanc();
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Barri barri = new Barri();
        barri.despertaFumadors();
        barri.obreEstanc();

        while(!barri.tancarEstanc()) {}
    }
}
