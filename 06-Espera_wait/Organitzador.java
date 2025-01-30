public class Organitzador {

    private Assistent[] asis = new Assistent[10];
    private Esdeveniment esde = new Esdeveniment(5);

    public Organitzador(){
        for(int i =0; i<asis.length; i++){
            asis[i] = new Assistent(esde, "Assistent " + i);
        }
    }

    public void iniciaOrganitzador(){
        for(Assistent a : asis){
            a.start();
        }
    }

    public static void main(String[] args) {
        Organitzador o = new Organitzador();
        o.iniciaOrganitzador();
    }
}
