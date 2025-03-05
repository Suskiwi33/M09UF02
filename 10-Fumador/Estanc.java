import java.util.ArrayList;
import java.util.Random;

public class Estanc extends Thread{
    ArrayList<Tabac> tabacs;
    ArrayList<Llumi> llumins;
    ArrayList<Paper> papers;
    Boolean flag;
    Random rnd;

    public Estanc (){
        this.tabacs = new ArrayList<>();
        this.papers = new ArrayList<>();
        this.llumins = new ArrayList<>();
        this.flag=true;
        this.rnd = new Random();
    }

    public void nouSubministrament (){
        int aleatori = rnd.nextInt(3);
        if(aleatori==0){addTabac(new Tabac());}
        if(aleatori==1){addPaper(new Paper());}
        if(aleatori==2){addLlumi(new Llumi());}
    }

    public void addTabac(Tabac tabac){
        System.out.println("Afegint tabac");

        tabacs.add(tabac);
        synchronized (this) {
            notifyAll();
        }
    }
    public void addPaper(Paper paper){
        System.out.println("Afegint paper");

        papers.add(paper);
        synchronized (this) {
            notifyAll();
        }
    }
    public void addLlumi(Llumi llumi){
        System.out.println("Afegint llumi");
        
        llumins.add(llumi);
        synchronized (this) {
            notifyAll();
        }
    }

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

        System.out.println("Estanc obert");

        while(flag){
            nouSubministrament();
            int temps = 500 + rnd.nextInt(1000);
            try {
                Thread.sleep(rnd.nextInt(temps));
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
            

        }
        System.out.println("Estanc tancat");
    }

}
