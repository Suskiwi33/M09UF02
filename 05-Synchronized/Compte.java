public class Compte {

    private double saldo;

    private static Compte instancia;

    private Compte() {
        this.saldo = 0.0;
    }

    public static Compte getInstance() {
        if (instancia == null) {
            instancia = new Compte();
        }
        return instancia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
    
        this.saldo = saldo;
        
    }
}