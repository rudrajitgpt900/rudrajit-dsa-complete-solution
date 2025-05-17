package rudy.dsa.Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LargeSubarrayofK {

    public int[] largestSubarray(int[] arr, int k) {
        // Your code goes here
        //I need to store the indices of start and end that represent the subarray of size k
        int n = arr.length;
        int []ans = new int[k];
        if(k>n) return ans;
        if(k==n) return arr;
        if(k==1){
            ans[0] = Arrays.stream(arr).max().getAsInt();
            return ans;
        }
        int startA = 0, endA= k-1;
        int startB = 1, endB = k;
        int start =-1, end =-1;

        while(startA<n && startB<n && endA<n && endB<n){
            if(isGreater(arr , startA , endA , startB , endB)){
                start = startA;
                end = endA;
            }
            else{
                start = startB;
                end = endB;
            }
            startA++; startB++; endA++; endB++;
        }
        int index = 0;
        for(int i=start; i<=end; i++){
            ans[index]= arr[i];
            index++;
        }
        return ans;
    }
    public boolean isGreater(int[]arr , int startA , int endA , int startB , int endB ){
        /*
            In given arr
            arrA = [startA -> endA] endA - startA + 1 = k
            arrB = [startB -> endB] endB - startB + 1 = k

            fn(arr, 1, 3 , 2, 4)
        */
        return arr[startA] > arr[startB];


    }

    public static void main(String[] args) {
        LargeSubarrayofK subarrayofK = new LargeSubarrayofK();
        int[] arr = {1, 4, 5, 2, 3};
       // System.out.println(Arrays.toString(subarrayofK.largestSubarray(arr,4)));

        List<Integer> collect = Arrays.stream(arr).boxed().sorted((a, b) -> b - a).toList();
        System.out.println(collect);

    }
}
