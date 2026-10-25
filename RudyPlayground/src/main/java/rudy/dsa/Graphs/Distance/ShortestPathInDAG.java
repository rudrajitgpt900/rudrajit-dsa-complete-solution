package rudy.dsa.Graphs.Distance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class Pair{
    public int v;
    public int wt;

    Pair(int v, int wt){
        this.v=v;
        this.wt=wt;
    }
}
public class ShortestPathInDAG {
    public static int[] shortestPathInDAG(int n, int m, int [][]edges) {
        // Write your code here
        int[]dis= new int[n];
        Arrays.fill(dis , (int) 1e9);
        dis[0]=0;
        ArrayList<ArrayList<Pair>>adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int u= edges[i][0];
            int v = edges[i][1];
            int weight = edges[i][2];

            adj.get(u).add(new Pair(v,weight));
        }
        boolean []vis= new boolean[n];
        Stack<Integer>stack= new Stack<>();
        for(int i=0;i<n;i++){
            if(!vis[i]){
                topoDfs(i,adj,vis,stack);
            }
        }
        System.out.println("TOPO: "+ stack);
        while (!stack.isEmpty()){
            Integer popped = stack.pop();
            for (Pair pair : adj.get(popped)) {
                int v =pair.v;
                int wt = pair.wt;
                if(dis[popped]+wt < dis[v]){
                    dis[v]= dis[popped]+wt;
                }

            }
        }
        for(int i =0; i<n;i++){
            if(dis[i]== (int) 1e9)
                dis[i] = -1;
        }

        return dis;
    }

    private static void topoDfs(int i, ArrayList<ArrayList<Pair>> adj, boolean[] vis, Stack<Integer> stack) {
        vis[i]=true;
        for(Pair pair: adj.get(i)){
            if(!vis[pair.v]){
                topoDfs(pair.v, adj,vis,stack);
            }
        }

        stack.push(i);

    }

    public static void main(String[] args) {
        //[0, 1, 2], [1, 2, 3], [0, 2, 6]].
        //3 3
        //2 0 4
        //0 1 3
        //2 1 2
        int[][]edges = {{2,0,4} , {0,1,3}, {2,1,2}};
        System.out.println(Arrays.toString(ShortestPathInDAG.shortestPathInDAG(3, 3, edges)));
    }
}
