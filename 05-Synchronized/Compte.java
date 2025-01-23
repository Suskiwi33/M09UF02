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

    public synchronized double getSaldo() {
        return saldo;
    }

    public synchronized void setSaldo(double saldo) {
    
        this.saldo = saldo;
        
    }
    public synchronized void agregar(double cant){
        saldo += cant;
    }
    public synchronized void treure(double cant){
        saldo -= cant;
    }
}