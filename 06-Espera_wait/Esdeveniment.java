import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


public class Esdeveniment {
    private ArrayList<Assistent> assistent = new ArrayList<>();
    private int placesMax;
    private int placesDispo;

    public Esdeveniment (int places){

        this.placesMax = places;
        this.placesDispo = places;

    }

    public synchronized Boolean ferReserva (Assistent a){
        if(placesDispo > 0){
            assistent.add(a);
            placesDispo -= 1;
            System.out.println(a.getNom() + " ha fet una reserva. Places disponibles: " + placesDispo);
            return true;
        }else{
            System.out.println(a.getNom() + " no ha pogut fer una reserva perque no queden places. Places disponibles:" + placesDispo);
            return false;
        }
        
    }

    public synchronized Boolean cancelaReserva(Assistent a) {
        boolean checkIn = false;
        Iterator<Assistent> iterador = assistent.iterator();
        
        while (iterador.hasNext()) {
            Assistent check = iterador.next();
            if (check.getNom().equals(a.getNom())) {
                iterador.remove();
                placesDispo++;
                checkIn = true;
                break;
            }
        }
        
        if (checkIn) {
            System.out.println(a.getNom() + " ha cancel·lat una reserva. Places disponibles: " + placesDispo);
            return true;
        } else {
            System.out.println(a.getNom() + " no ha pogut cancel·lar una reserva inexistent. Places disponibles: " + placesDispo);
            return false;
        }
    }
}
