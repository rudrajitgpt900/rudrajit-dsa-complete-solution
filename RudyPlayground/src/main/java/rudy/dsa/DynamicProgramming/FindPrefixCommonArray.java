package rudy.dsa.DynamicProgramming;

import java.util.*;
import java.util.stream.Stream;

public class FindPrefixCommonArray {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[]res = new int[A.length];
        Set<Integer>set1 = new HashSet<>();
        Set<Integer>set2 = new HashSet<>();

        int i =0, j= 0;
        while (i!= A.length && j!= B.length){
            set1.add(A[i]);
            set2.add(B[j]);
            if(set1.equals(set2)){
                res[i]= set1.size();
            }
            i++;
            j++;
        }
        return res;
    }

    public int findKRotation(List<Integer> arr) {
        int n = arr.size();
        int low = 0;
        int high = n-1;

        int min = Integer.MAX_VALUE;
        int minInd = -1;

        while(low<=high){
            int mid = (low+high)>>1;

            if(arr.get(low)<arr.get(mid)){
                if(arr.get(low)<min){
                    min = arr.get(low);
                    minInd = low;

                }
                low = mid +1;
            }else{
                if(arr.get(mid)<min){
                    min = arr.get(mid);
                    minInd = mid;

                }
                high = mid - 1;
            }
        }

        return minInd;
    }

    public static void main(String[] args) {
        FindPrefixCommonArray obj = new FindPrefixCommonArray();
        List<Integer> list = List.of(4, 5, 6, 7, 0, 1, 2, 3);
        System.out.println(obj.findKRotation(list));

    }
}
