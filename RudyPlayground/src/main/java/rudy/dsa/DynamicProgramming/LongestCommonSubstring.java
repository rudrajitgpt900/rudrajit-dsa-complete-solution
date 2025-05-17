package rudy.dsa.DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubstring {

    int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here

        int[][]dp = new int[n+1][m+1];
        int ans = 0;
        for(int i=1;i<=n;i++ ){
            for(int j=1;j<=m;j++){
                if(S1.charAt(i-1)== S2.charAt(j-1)){
                    dp[i][j]= 1+ dp[i-1][j-1];
                    ans = Math.max(ans , dp[i][j]);
                }
            }
        }

        //System.out.println(Arrays.deepToString(dp));
        return ans;
    }

    private int fn(int i, int j, String s1, String s2, Integer[][] dp) {

        if(i>s1.length() || j>s2.length() )
            return 0;
        if(dp[i][j]!= null) return dp[i][j];

        if(s1.charAt(i)== s2.charAt(j))
            return dp[i][j]= 1 + fn(i+1,j+1,s1,s2,dp);
        return dp[i][j]=0;
    }

    public static void main(String[] args) {
        LongestCommonSubstring obj = new LongestCommonSubstring();
        int ans =obj.longestCommonSubstr("ABCDGH", "ACDGHR",6 , 6);
        System.out.println(ans);
    }
}
