package rudy.dsa.DynamicProgramming;

public class LongestIncreasingSubsequence {


    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int prevInd = -1;
        int startInd = 0;
        Integer[][]dp = new Integer[n][n+1];
        return fn(startInd,prevInd,nums,n, dp );

    }

    private int fn(int startInd, int prevInd, int[] nums, int n, Integer[][] dp) {
        if(startInd==n)return 0;

        if(dp[startInd][prevInd+1]!=null)return dp[startInd][prevInd+1];

        int len = fn(startInd+1, prevInd,nums,n, dp);
        if(prevInd==-1 || nums[startInd]>nums[prevInd+1]){
            len = Math.max(len , 1+ fn(startInd+1, startInd, nums,n, dp));
        }

        return dp[startInd][prevInd+1]=len;
    }
}
