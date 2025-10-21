package rudy.dsa.Graphs.DisjointSetDesign;

import java.util.ArrayList;

public class DisjointSet {
    public ArrayList<Integer>rank;
    public ArrayList<Integer>parent;

    DisjointSet(int noOfVertices){
        this.rank= new ArrayList<>();
        this.parent= new ArrayList<>();
        for(int i =0; i<noOfVertices+1;i++){
            this.rank.add(0);
            this.parent.add(i);

        }

    }

    public int findParent(int node){
        if(this.parent.get(node) == node)
            return node;
        this.parent.set(node , findParent(this.parent.get(node)));

        return this.parent.get(node);
    }

    public void unionByRank(int u, int v){
        int pu= findParent(u);
        int pv = findParent(v);
        if(pu == pv)
            return;

        if(this.rank.get(pu) < this.rank.get(pv)){
            this.parent.set(pu,pv);
        } else if (this.rank.get(pu)>this.rank.get(pv)) {
            this.parent.set(pv,pu);
        }
        else {
            this.parent.set(pv,pu);
            this.rank.set(pu , this.rank.get(pu)+1);
        }
    }



    public boolean isSameComponent(int u, int v){
        if(u==v)
            return true;
        return this.findParent(u)== this.findParent(v);
    }

}
