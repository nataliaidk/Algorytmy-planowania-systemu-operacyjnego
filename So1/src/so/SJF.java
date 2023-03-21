package so;

public class SJF extends Processes{

    public SJF(String label, int changeInterval){
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

        int index = -1;
        if(waiting.size()>1){
            for(Process p2 : waiting){
                if(p.getTime()<p2.getTime() && waiting.indexOf(p2)>0){
                    index = waiting.indexOf(p2);
                    break;
                }else if(p.getTime()==p2.getTime()){
                    index = waiting.indexOf(p2)+1;
                    break;
                }
            }
        }
        if(index<0){
            waiting.add(p);
        }else{
            waiting.add(index,p);
        }
        setWaitingTime(p);

        // podliczenie od nowa czasu oczekiwania
        if(index != -1){
            for(int i=index; i<waiting.size(); i++){
                setWaitingTime(waiting.get(i));
            }
        }

        System.out.print(label+" |Procesow w kolejce: " + waiting.size());
        System.out.print(" Czas obecny oczekiwania: " + String.format("%5d%2s", p.getWaitingTime(), "ms") + "\n");
    }

}




