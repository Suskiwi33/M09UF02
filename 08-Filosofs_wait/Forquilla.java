public class Forquilla{

    private static final int LLIURE = -1;
    private int num;
    private int numPropietari;

    public Forquilla(int num){
        this.num = num;
        
    }

    public void setNum(int num){this.num = num;}
    public int getNum(){return this.num;}

    public void setNumPropietari(int numProp){this.numPropietari = numProp;}
    public int getNumPropietari(){return this.numPropietari;}

    public void setForquillaLliure(){this.numPropietari = LLIURE;}
}
