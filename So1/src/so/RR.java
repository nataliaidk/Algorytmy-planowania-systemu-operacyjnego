package so;

public class RR extends Processes {

    private int timeQuant = 0;
    private int Quant;


    public RR(String label , int changeInterval, int Quant) {
        super(label, changeInterval);
        this.Quant = Quant;
    }

    public void step(){
        if(waiting.size()>0){
            Process p = waiting.get(0);
            if(p.getTime()<=1){
                timeQuant = 0;
                waiting.remove(p);
                contectsChange();
                used.add(p);
            }else if(timeQuant==Quant){
                waiting.remove(p);
                waiting.add(p);
                if(waiting.size()>1){
                    contectsChange();
                }
                setWaitingTime(p);
                timeQuant = 0;
            }
            if(timeChange>0){
                timeChange--;
            }else{
                p.decreaseTime(1);
                timeQuant++;
            }
        }else{
            timeQuant = 0;
        }

    }

    @Override
    public void add(Process p)
    {
        waiting.add(p);
        setWaitingTime(p);
        System.out.print(label+" |Procesow w kolejce: " + waiting.size());
        System.out.print(" Czas obecny oczekiwania: " + String.format("%5d%2s", p.getWaitingTime(), "ms") + "\n");
    }


}


