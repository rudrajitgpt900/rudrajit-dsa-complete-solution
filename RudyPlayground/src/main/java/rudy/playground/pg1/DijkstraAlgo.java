package rudy.playground.pg1;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.PriorityQueue;

public class DijkstraAlgo {

    public  int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int[]dist = new int[V];
        Arrays.fill(dist, (int)1e9);
        dist[S]=0;

        PriorityQueue<int[]>pq= new PriorityQueue<>((a,b)->a[0]-b[0]);

        pq.add(new int[]{dist[S], S});
        while(!pq.isEmpty()){
            int[] peek = pq.peek();
            int u = peek[1];
            int dis = peek[0];
            ArrayList<ArrayList<Integer>> neighbours = adj.get(u);
            for(ArrayList<Integer> neighbor : neighbours){
                int v = neighbor.get(0);
                int wt = neighbor.get(1);
                if(dis + wt < dist[v]){
                    dist[v]=dis+wt;
                    pq.add(new int[]{dist[v], v});
                }
            }

        }
        return dist;

    }



}
