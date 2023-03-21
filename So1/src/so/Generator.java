package so;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {

    private List<Process> process;
    private static List<Processes> processes;
    private Processes fcfs;
    private Processes sjf;
    private Processes rr;

    public Generator(int changeInterval, int Quant){
        processes = new ArrayList<>();
        process= new ArrayList<>();


        fcfs = new FCFS("Algorytm FCFS", changeInterval);
        sjf = new SJF("Algorytm SJF", changeInterval);
        rr = new RR("Algorytm rotacyjny", changeInterval, Quant);

        processes.add(fcfs);
        processes.add(sjf);

        processes.add(rr);
    }

    public static Random random = new Random();

    public void GeneratingProcesses(int ilosc)
    {
        int timeforprocess = random.nextInt(1,6);
        for(int i=0; i<ilosc; i++){


            process.add(new Process("nazwa" + i, timeforprocess));



        }
        process.get(0).setWaitingTime(timeforprocess);

    }



    public void showProcesses(){
        for(Process p : process){
            System.out.println(p);
        }
    }
    public Process getProcess()
    {
        Process p = process.get(0);
        return p;
    }
    public void deleteProcess(Process p)
    {
        process.remove(p);

    }


    public Process cloneProcess(Process p){
        try {
            p = p.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }


    public boolean step(){
        if(process.size()>0){
            Process p = getProcess();
            System.out.println("System |Zglosil sie proces: " + p);
            for(Processes proc : processes){
                proc.add(cloneProcess(p));
            }
           deleteProcess(p);
        }
        for(Processes proc : processes){
            proc.step();
        }

        if(process.size()==0){
            System.out.println("nie dziala");
            return false;

        }
        System.out.println("dziala");
        return true;
    }
    public int howManyActiveProcesses() {
        int i = 0;
        for(Processes proc : processes){
            i = i + proc.getWaiting().size();
        }
        return i;
    }



    public List<Process> getWaiting(Processes proc){
        return proc.getWaiting();
    }
    public String pobierzEtykiete(Processes proc){
        return proc.getLabel();
    }
    public double getAverageWaitingTime(Processes proc){
        return proc.averageWaitingTime();
    }
    public static List<Processes> getProcesses(){
        return processes;
    }





}
