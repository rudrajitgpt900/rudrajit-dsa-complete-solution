package rudy.dsa.Graphs.Distance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class FlightInfo implements Comparable<FlightInfo>{
    public int stops;
    public int wt;
    public int node;

    public FlightInfo(int stops, int wt, int node) {
        this.stops = stops;
        this.wt = wt;
        this.node = node;
    }

    @Override
    public int compareTo(FlightInfo o) {
        if(this.stops != o.stops)
            return this.stops-o.stops;
        else if(this.node != o.node)
            return this.wt - o.wt;
        return this.wt-o.wt;
    }
}

public class CheapestFlightwithK {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<FlightInfo>>adj = new ArrayList<>();
        int []dist = new int[n];
        Arrays.fill(dist , (int)1e9);
        dist[src]=0;
        int ans = (int) 1e9;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<FlightInfo>());
        }

        for(int i=0;i<flights.length;i++){
            int u = flights[i][0];
            int v= flights[i][1];
            int wt = flights[i][2];
            adj.get(u).add(new FlightInfo(0,wt,v));
        }

        PriorityQueue<FlightInfo> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new FlightInfo(0,0,src));

        while (!priorityQueue.isEmpty()){
            int u = priorityQueue.peek().node;
            int wt = priorityQueue.peek().wt;
            int stops = priorityQueue.peek().stops;

            priorityQueue.poll();
            ArrayList<FlightInfo> flightInfos = adj.get(u);
            if(stops > k)
                continue;
            for( FlightInfo flightInfo: flightInfos){
                int v = flightInfo.node;
                int cost = flightInfo.wt;

                if(wt +cost < dist[v] && stops<=k){
                    dist[v]= wt + cost;
                    priorityQueue.add(new FlightInfo(stops+1,wt+cost,v ));
                }

            }
        }
        if(dist[dst] != (int)1e9)
            return dist[dst];
        return -1;
    }
}
