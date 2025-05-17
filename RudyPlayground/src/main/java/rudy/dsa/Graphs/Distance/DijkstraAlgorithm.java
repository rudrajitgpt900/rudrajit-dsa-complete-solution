package rudy.dsa.Graphs.Distance;

import java.util.*;

class PairDJ {
    int v,wt;
    PairDJ(int v, int wt){
        this.v=v;
        this.wt=wt;
    }
}
public class DijkstraAlgorithm {

    public static List<Integer> dijkstra(int[][] edge,int vertices, int edges,int source){
        // Write your code here.
        List<List<PairDJ>> adj=new ArrayList<>();
        Queue<PairDJ> pq=new PriorityQueue<>(Comparator.comparingInt(x -> x.wt));
        pq.add(new PairDJ(source,0));
        for(int i=0;i<vertices;i++){
            List<PairDJ> tem=new ArrayList<>();
            adj.add(tem);
        }
        for (int[] ints : edge) {
            int a = ints[0];
            int b = ints[1], c = ints[2];
            adj.get(a).add(new PairDJ(b, c));
            adj.get(b).add(new PairDJ(a, c));
        }
        int dis[]=new int[vertices];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[source]=0;
        while(!pq.isEmpty()){
            PairDJ p=pq.poll();
            for(PairDJ curr:adj.get(p.v)){
                if(p.wt+curr.wt<dis[curr.v]){
                    dis[curr.v]=p.wt+curr.wt;
                    pq.add(new PairDJ(curr.v,dis[curr.v]));

                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i:dis) ans.add(i);
        return ans;
    }
    public static void main(String[] args) {
        int[][]ed = {{1,0,9},
                {2,1,8} , {0,2,4}  } ;

        System.out.println(dijkstra(ed,3,3,2 ));

    }
}
