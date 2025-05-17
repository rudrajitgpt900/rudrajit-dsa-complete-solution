package rudy.playground.pg1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class FormList {

    public static int solution( int[] A){

        int n = A.length;
        List<Integer>list = new ArrayList<>();

        int index =0;
        while (A[index] !=-1){
            int cur = A[index];
            list.add(cur);
            index=cur;
        }


        return list.size()+1;
    }

    public static void main(String[] args) {
        int[]a = {1,4,-1,3,2};
        System.out.println(solution(a));

        List<Integer>list = List.of(1,2,4,2,3,5);
        list =  list.stream().distinct().toList();
        System.out.println(list);
    }
}
