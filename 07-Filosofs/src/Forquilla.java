public class Forquilla{
    private boolean enUs;
    private int num;

    public Forquilla(int num){
        this.num = num;
        this.enUs = false;
    }

    public void setUs (boolean us){this.enUs = us;}
    public boolean getUs(){return enUs;}
    public int getNum(){return this.num;}

}
