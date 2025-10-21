package rudy.dsa.Graphs.DisjointSetDesign;

public class MinOperationToConnectGraph {

    public int makeConnected(int n, int[][] connections) {
        // Code here

        DisjointSet disjointSet = new DisjointSet(n);
        int extraEdge = 0;
        for(int[]edge : connections){
            int u =edge[0];
            int v = edge[1];
            if(disjointSet.findParent(u) == disjointSet.findParent(v))
                extraEdge++;
            else{
                disjointSet.unionByRank(u,v);
            }



        }

        int ans =0;
        for(int i= 0;i<n;i++){
            if(disjointSet.parent.get(i)==i)
                ans++;
        }
        ans = ans -1;
        if(extraEdge>=ans)
            return ans;
        return -1;
    }
}
