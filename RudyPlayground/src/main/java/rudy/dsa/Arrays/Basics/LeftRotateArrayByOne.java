package rudy.dsa.Arrays.Basics;

public class LeftRotateArrayByOne {
    static int[] rotateArray(int[] arr, int n) {
        // Write your code here.

        if(n==0)
            return arr;

        for(int i =1 ; i<n ; i++){
            int curr = arr[i-1];//2
            arr[i-1] =arr[i];
            arr[i] = curr;
        }

        return arr;

    }
}
