package so;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Process implements Cloneable {

    private static int index=0;
    private int id;

    private String name;

    public int getTime() {
        return time;
    }

    private int time;
    public void decreaseTime(int time){
        this.time -= time;
    }


    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int waitingTime=0;

    public Process(String name, int time){
        ++index;
        this.id = index;
        this.name = name;
        this.time = getTime();
    }

    public String toString(){
        return String.format("%5d%10s%8s",id, name,time+"ms");

    }
    public Process clone() throws CloneNotSupportedException {
        return (Process)super.clone();}

}
