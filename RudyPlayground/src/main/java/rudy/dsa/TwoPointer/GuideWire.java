package rudy.dsa.TwoPointer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GuideWire {

    //[1, 3, -4, 2, -1]

    private static List<List<Integer>> generateSubstrings(int[] A, int size) {
        List<List<Integer>> substrings = new ArrayList<>();
        for (int i = 0, j = 0; j < A.length; j++) {
            if (j - i + 1 == size) {
                List<Integer> substring = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    substring.add(A[k]);
                }
                substrings.add(substring);
                i++;
            }
        }
        return substrings;
    }

    public static  int solution(int[]A,int k, int l){

        int n= A.length;
        List<List<Integer>> subs1 = generateSubstrings(A, k);
        List<List<Integer>>subs2 = generateSubstrings(A,l);

        int max = Integer.MIN_VALUE;
        for(List<Integer> fragment1 : subs1){
            for(List<Integer> fragment2 : subs2){
                max= Math.max(max , compareFragments(fragment1 , fragment2));
            }
        }

        return max;
    }

    private static int compareFragments(List<Integer> fragment1, List<Integer> fragment2) {
        int ans=0;
        for(Integer num : fragment1){
            if(!fragment2.contains(num)){
                ans+=num;

            }
            else{
                if(num <0){
                    num=num*(-1);
                }
                else{
                    num= -num;
                }
                ans+=num;
            }
        }

        for(Integer num : fragment2){
            if(fragment1.contains(num)){
                continue;
            }
            ans +=num;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[]A= {1,1,1,1,1};
        System.out.println(generateSubstrings(A,4));
        System.out.println(generateSubstrings(A,1));
        System.out.println(solution(A,4,1));

    }
}
