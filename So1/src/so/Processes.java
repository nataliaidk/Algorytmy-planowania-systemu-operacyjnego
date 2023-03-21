package so;

import Main.Main;

import java.util.ArrayList;
import java.util.List;


public abstract class Processes{
protected String label;
protected List<Process> waiting;
protected List<Process> used;
protected int timeChange=0;
private int changeInterval;


public Processes(String label, int changeInterval){
        this.label=label;
        waiting  = new ArrayList<>();
        used = new ArrayList<>();
        this.changeInterval=changeInterval;
        }

public abstract void step();
public void contectsChange(){
        timeChange+= changeInterval;
    }


    public  double averageWaitingTime(){
        double time = 0;
        for(Process p : used){
            time += p.getWaitingTime();
        }
        if (used.size() != 0){
        return time/used.size();
        }

        return 420.0;
    }

    public void setWaitingTime(Process p){

        for(Process x : waiting){
            if(x.equals(p)){
                p.setWaitingTime(Time.time);
            }
            Time.time += x.getTime();
            Time.time += changeInterval;
        }
        try {
            used.add(p.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
    public abstract void add(Process p);

    public  List<Process> getWaiting(){
        return waiting;
    }

    public String getLabel(){
        return label;
    }


}




























