import java.util.ArrayList;
import java.util.Random;

public class Estanc extends Thread{
    ArrayList<Tabac> tabacs;
    ArrayList<Llumi> llumins;
    ArrayList<Paper> papers;
    Boolean flag;
    Random rnd;

    public Estanc (){
        this.flag=true;
        this.rnd = new Random();
    }

    public void nouSubministrament (){
        int aleatori = rnd.nextInt(3);
        if(aleatori==0){addTabac();}
        if(aleatori==1){addPaper();}
        if(aleatori==2){addLlumi();}
    }

    public void addTabac(){tabacs.add(new Tabac());}
    public void addPaper(){papers.add(new Paper());}
    public void addLlumi(){llumins.add(new Llumi());}

    public Tabac venTabac(){
        if(tabacs.size()>0){
            Tabac t = tabacs.get(tabacs.size()-1);
            tabacs.remove(tabacs.size()-1);
            return t;
        }else{return null;}
    }
    public Paper venPaper(){
        if(papers.size()>0){
            Paper p = papers.get(papers.size()-1);
            papers.remove(papers.size()-1);
            return p;
        }else{return null;}
    }
    public Llumi venLlumi(){
        if(llumins.size()>0){
            Llumi l = llumins.get(llumins.size()-1);
            llumins.remove(llumins.size()-1);
            return l;
        }else{return null;}
    }

    public void tancarEstanc(){this.flag=false;}

    @Override
    public void run(){

        while(flag){
            nouSubministrament();
            int temps = 500 + rnd.nextInt(1000);
            try {
                Thread.sleep(rnd.nextInt(temps));
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
            

        }

    }

}
