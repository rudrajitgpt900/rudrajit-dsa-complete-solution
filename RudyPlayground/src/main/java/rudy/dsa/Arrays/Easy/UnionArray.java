package rudy.dsa.Arrays.Easy;

import java.util.ArrayList;
import java.util.List;

public class UnionArray {

    public static List< Integer > sortedArray(int []a, int []b) {
        // Write your code here

        List<Integer> result= new ArrayList<>();
        int n = a.length;
        int m = b.length;
        int i=0;
        int j=0;

        while(i<n && j<m){

            if(a[i] <= b[j]){
                if(result.isEmpty() ||result.get(result.size()-1)!=a[i])result.add(a[i]);
                i++;
            }
            else{
                if(result.isEmpty() ||result.get(result.size()-1)!=b[j])result.add(b[j]);
                j++;
            }
        }

        while(i<n){
            if(result.get(result.size()-1)!=a[i])result.add(a[i]);
            i++;
        }

        while(j<m){
            if(result.get(result.size()-1)!=b[j])result.add(b[j]);
            j++;
        }

        return result;
    }
}
