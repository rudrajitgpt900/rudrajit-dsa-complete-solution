package rudy.dsa.Graphs.DisjointSetDesign;

import java.util.ArrayList;

public class NoOfProvinces {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {

        // code here

        DisjointSet disjointSet = new DisjointSet(V);
        for(int i =0; i<V;i++){
            for(int j=0;j<V;j++){
                if(adj.get(i).get(j)==1){
                    disjointSet.unionByRank(i,j);
                }
            }
        }
        int cnt = 0;
        for(int i =0;i<V;i++){
            if(disjointSet.parent.get(i)==i)
                cnt++;

        }
        return cnt;
    }
}
