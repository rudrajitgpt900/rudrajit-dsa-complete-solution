package rudy.dsa.Arrays.Easy;

import java.util.ArrayList;

public class LeftRotateByK {
    public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) {

        // Write your code here.
        int n = arr.size();
        k = k%n;
        if(k == 0){
            return arr;
        }

        rev(arr , 0 , n-1);
        rev(arr , 0 , n-1-k);
        rev(arr , n-1-k+1 , n-1);
        return arr;
    }

    public static void rev(ArrayList<Integer> arr, int start , int end){

        while(start<end){
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end , temp);
            start++;
            end--;

        }
    }

}
