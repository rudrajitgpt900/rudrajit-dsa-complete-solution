package rudy.dsa.DynamicProgramming;

import java.util.Arrays;

public class PartitionSubsetAbsDiff {

    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int S=0;
        for(int i : nums){
            S+=i;
        }
        boolean[][]dp = new boolean[n][S+1];

        for(int i =0 ; i<=S; i++){
            dp[0][i]= nums[0]==i;
        }

        for(int i =1; i<n; i++){
            for(int j= 0; j<=S; j++){
                boolean notPick = dp[i-1][j];
                boolean pick = false;
                if(nums[i]<=j){
                    pick = dp[i-1][j-nums[i]];
                }
                dp[i][j]= pick||notPick;
            }
        }
        boolean[] possibleS1 = dp[n-1];
        int min = Integer.MAX_VALUE;
        for(int i= 0 ; i< possibleS1.length;i++){
            if(possibleS1[i]){
                int s2 = S- i;
                min = Math.min(min , Math.abs(i -s2));
            }
        }
        return min;
    }


    public static void main(String[] args) {
        int num[] = {2,1,0,4,2,9};
        PartitionSubsetAbsDiff obj = new PartitionSubsetAbsDiff();
        System.out.println(obj.minimumDifference(num));
    }
}
