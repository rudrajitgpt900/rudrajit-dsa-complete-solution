package rudy.dsa.Arrays.Medium;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Driver{
    public String name;
    public  int lapTime;

    Driver(String name , int lapTime){
        this.lapTime = lapTime;
        this.name = name;
    }
}
public class DriverElimination {

    public static  String[] getDriver(String [][] driverInfo){

        int totalLaps = driverInfo.length;
        String []ans = new String[totalLaps];
        Set<String> driverSet = new LinkedHashSet<>();
        PriorityQueue<Driver> pq = new PriorityQueue<>((a,b)-> {
            if (a.lapTime == b.lapTime)
                return a.name.compareTo(b.name);
            return b.lapTime - a.lapTime;
        });

        for (String[] currentLap : driverInfo) {
            for (String currentDriver : currentLap) {
                String[] arr = currentDriver.split(" ");
                String name = arr[0];
                int lapTime = Integer.parseInt(arr[1]);
                if (!driverSet.contains(name)) {
                    pq.add(new Driver(name, lapTime));
                }
            }
            int maxLapTime = pq.isEmpty() ? 0 : pq.peek().lapTime;
            while (!pq.isEmpty() && pq.peek().lapTime == maxLapTime) {
                driverSet.add(pq.peek().name);
                pq.poll();
            }
            pq.clear();
        }

        int ind = 0;
        for(String driver : driverSet){
            ans[ind]= driver;
            ind++;
        }

        return ans;
    }


    public static void main(String[] args) {
        String[][]driverInfo= {
                {"Harold 164", "Gina 155", "Eddie 154", "John 150"},
                {"Harold 170", "Gina 154", "Eddie 154", "John 180"},
                {"Harold 153", "Gina 154", "Eddie 154", "John 159"},
                {"Harold 164", "Gina 155", "Eddie 154", "John 150"},
        };

        //{Harold , Eddie, Gina, John}
        System.out.println(Arrays.toString(getDriver(driverInfo)));
    }
}
