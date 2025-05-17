package rudy.dsa.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class BurstBalloon {
    public int maxCoins(int[] nums) {
        List<Integer>list = new ArrayList<>();
        for(int i = 0; i< nums.length; i++)
            list.add(nums[i]);
        list.add(0,1);
        list.add(1);
        int n = nums.length;
        Integer[][]dp = new Integer[n+1][n+1];
        return fn(1, n ,list,dp);


    }

    private int fn(int i, int j, List<Integer> list, Integer[][] dp) {
        if(i > j)
            return 0;
        if(dp[i][j]!=null)
            return dp[i][j];

        int max = Integer.MIN_VALUE;
        for (int ind =i ; ind<=j ; ind++){
            int cost = list.get(ind)*list.get(i-1) *list.get(j+1)
                        + fn(i ,ind-1,list, dp)
                        + fn(ind+1 , j , list, dp);

            max = Math.max(max , cost);
        }
        return dp[i][j]=max;
    }
}
