import java.util.Random;

public class Coet extends Thread{

    private final static Motor[] motors = new Motor[4];

    public  Coet() {
        for (int i = 0; i < motors.length; i++) {
            motors[i] = new Motor(i);
        }
    }

    public static void passaAPotencia(int p){
        if(p<=0 || p>=10){
            for (Motor motor : motors) {
                motor.setPotencia(p);
            }
        }else{
            System.out.println("Error, potencia no vàlida");
        }
    }

    public static void arranca(){
        
    }

    public static void main(String[] args) {
        System.out.println("Potencia inicial?");
        String pot = Entrada.readLine();
        try{
            passaAPotencia(Integer.parseInt(pot));
            arranca();
        }catch(Exception e){
            System.out.println("La potencia ha de ser un numero enter");
        }
    }
}
