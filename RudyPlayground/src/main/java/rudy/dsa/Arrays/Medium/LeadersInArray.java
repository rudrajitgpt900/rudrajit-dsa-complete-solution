package rudy.dsa.Arrays.Medium;

import java.util.ArrayList;
import java.util.List;

public class LeadersInArray {


    /*
    * Leader/Superior : An element is called a Superior Element if it is greater than all the elements present to its right.
    *
    * a = [1, 2, 3, 2]
    *
    *
    * leaders={3,2}
    * */
    public static List< Integer > superiorElements(int []a) {
        // Write your code here.

        List<Integer> leaders = new ArrayList<>();
        int n = a.length;
        leaders.add(a[n - 1]);
        int lastLeader= a[n-1];
        for(int i =n-2; i>=0; i--){
            int current = a[i];
            if(current > lastLeader){
                leaders.add(current);
                lastLeader = current;
            }

        }
        return leaders;

    }

    public static void main(String[] args) {
        int a[]= {1,2,2,1};
        System.out.println(superiorElements(a));
    }
}
