package rudy.dsa.Arrays.Basics;

public class LargestElement {

    static int largestElement(int[] arr, int n) {
        // Write your code here.
        if(n ==0)
            return 0;
        if(n==1)
            return arr[0];
        if(n==2)
            return Math.max(arr[0] , arr[1]);

        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            ans= Math.max(ans ,arr[i]);
        }

        return ans;

    }
}
