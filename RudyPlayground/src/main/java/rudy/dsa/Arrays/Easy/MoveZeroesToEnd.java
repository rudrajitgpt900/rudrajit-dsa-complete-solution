package rudy.dsa.Arrays.Easy;

import java.util.Arrays;

public class MoveZeroesToEnd {


    public static int[] moveZeros(int n, int []nums) {
        // Write your code here.
        if(n ==1)
            return nums;

        int start=-1;
        for(int i =0; i<n; i++){
            if(nums[i] == 0){
                start =i;
                break;
            }

        }
        if(start ==-1)
            return nums;

        for(int j =start+1; j<n;j++){
            if(nums[j]!=0){
                int temp = nums[j];
                nums[j]= nums[start];
                nums[start]= temp;
                start++;
            }
        }

        System.out.println(Arrays.toString(nums));
        return nums;
    }

}
