
package so;
import java.util.Arrays;

public class Time {

    public static int getTime() {
        return time;
    }

    public static void setTime(int time) {
        Time.time = time;
    }

    public static int time;


//    public static void CountingTime() {
//        while (true) {
//            int n = 1000000; // definiuje przedział od o do 99
//            boolean pierwsze[] = new boolean[n];
//            Arrays.fill(pierwsze, true);//wypelniam calosc true
//            pierwsze[0] = false;//0 i 1 od razu wyrzucam
//            pierwsze[1] = false;
//            for (int i = 2; i <= Math.sqrt(n); i++)// lece po tablicy do sqrt(n)
//            {
//
//                for (int t = i + i; t < n; t = t + i) {//wykreslam wieloktornosci
//
//                    pierwsze[t] = false;
//
//                }
//
//            }
//
//
//
//
//            time++;
//
//
//
//        }

}
