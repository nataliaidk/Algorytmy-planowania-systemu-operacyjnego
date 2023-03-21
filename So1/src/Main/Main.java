
package Main;

import so.Generator;
import so.Processes;


import java.util.Arrays;
import java.util.List;


public class Main {

    private static Object howManyActiveprocesses;

    public static void main(String[] args) {


        while (true) {
            int n = 10000000; // definiuje przedział od o do 99
            boolean pierwsze[] = new boolean[n];
            Arrays.fill(pierwsze, true);//wypelniam calosc true
            pierwsze[0] = false;//0 i 1 od razu wyrzucam
            pierwsze[1] = false;
            for (int i = 2; i <= Math.sqrt(n); i++)// lece po tablicy do sqrt(n)
            {

                for (int t = i + i; t < n; t = t + i) {//wykreslam wieloktornosci

                    pierwsze[t] = false;

                }

            }

//            Scanner scan = new Scanner(System.in);
//            System.out.println("Podaj interwał zmiany kontekstu (ms):");

            int changeInterval = 1;
//            System.out.println("Podaj kwant czasu:");
            int Quant = 2;
//            System.out.println("Podaj ilość procesów jaka ma być użyta w teście:)");
            int howManyActiveprocesses = 30;


            Generator g = new Generator(changeInterval, Quant);

            g.GeneratingProcesses(howManyActiveprocesses);



                System.out.println("*********************");
                System.out.println("ZAKOŃCZONO SYMULACJE");

                List<Processes> processes = Generator.getProcesses();
                String wyniki = "Średnie czasy : \n";
                for (Processes proc : processes) {
                    wyniki += proc.getLabel() + " | " +  proc.averageWaitingTime();
                    wyniki += "\n";
                }
                System.out.print(wyniki);
                //JOptionPane.showMessageDialog(null, wyniki, "Symulacja zakończona", JOptionPane.INFORMATION_MESSAGE);

            so.Time.time++;
            System.out.println(so.Time.time);
        }


    }
}
