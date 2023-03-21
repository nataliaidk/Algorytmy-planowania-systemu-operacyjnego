package so;

public class FCFS extends Processes {

    public FCFS(String label, int changeInterval){
        super(label, changeInterval);
    }


    @Override
    public void step() {

        while(waiting.size() != 0)
        {
            Process p = waiting.get(0);
            if(p.getTime()<=1){
                waiting.remove(p);
                contectsChange();
                used.add(p);
            }
            if (timeChange>0) timeChange--;


            else p.decreaseTime(1);
        }

    }

    @Override
    public void add(Process p) {

         waiting.add(p);
         setWaitingTime(p);

        System.out.print(label +" |Procesow w kolejce: " + waiting.size());
        System.out.print(" Czas obecny oczekiwania: " + String.format("%5d%2s", p.getWaitingTime(), "ms") + "\n");
    }
}
