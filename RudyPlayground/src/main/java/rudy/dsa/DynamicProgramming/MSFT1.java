package rudy.dsa.DynamicProgramming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Data{
    public int dist;
    public int cost;

    Data(int d, int c){
        this.dist=d;
        this.cost=c;
    }

}
public class MSFT1 {

    public int solution(int[] D, int[] C, int P) {
        // Implement your solution here
        int n= D.length;
        int ans=0;
        List<Data> list = new ArrayList<>();
        for(int i =0; i<n; i++){
            list.add(new Data(D[i], C[i]));
        }

        list.sort(Comparator.comparingInt(a -> a.dist));

        int reqrdMonitor = P;
        for(int i =0; i<list.size(); i++){
            Data current = list.get(i);

            if(current.cost<=reqrdMonitor){
                ans++;
                reqrdMonitor = reqrdMonitor- current.cost;
            }
            else
                break;
        }
        return ans;
    }

    public static void main(String[] args) {
        int a[]= {11,18,1};
        int c[]={9,18,8};
        MSFT1 o = new MSFT1();
        System.out.println( o.solution(a,c,18));
        char character = 'A';
        System.out.println("ASCII value of " + character + " is: " + (int) character);

    }
}

