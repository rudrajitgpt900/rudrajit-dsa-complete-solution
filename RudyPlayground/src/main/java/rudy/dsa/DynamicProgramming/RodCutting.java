package rudy.dsa.DynamicProgramming;

public class RodCutting {

    public int cutRod(int price[], int n) {
        //code here
        int len = price.length;
        Integer[][]dp = new Integer[len+1][n+1];
        return fn(price , len-1 , n , dp);
    }

    private int fn(int[]price , int ind , int W, Integer[][] dp){
        //BaseCase
        if(ind ==0){
            return W * price[0];
        }
        if(dp[ind][W]!=null)
            return dp[ind][W];
        //notTake;
        int notTake = fn(price, ind - 1, W, dp);
        int take = (int)1e9+7;
        int rodength = ind+1;
        if(rodength<= W)
            take = price[ind]+ fn(price, ind, W-rodength, dp);
        return dp[ind][W]=Math.max(take,notTake);
    }
}
