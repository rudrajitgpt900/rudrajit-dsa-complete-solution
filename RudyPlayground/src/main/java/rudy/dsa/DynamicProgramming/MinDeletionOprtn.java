package rudy.dsa.DynamicProgramming;



public class MinDeletionOprtn {

    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();
        Integer[][]dp = new Integer[n+1][m+1];

        int lcs = fn(n-1 , m-1 , word1, word2 , dp);
        return n - lcs;

    }

    private int fn(int i, int j, String word1, String word2, Integer[][] dp) {

        if(i<0 || j<0)
            return 0;
        if(dp[i][j]!=null)
            return dp[i][j];

        if(word1.charAt(i)== word2.charAt(j))
            return dp[i][j]= 1 + fn(i-1,j-1,word1,word2,dp);
        return dp[i][j]= Math.max(fn(i,j-1,word1,word2,dp) , fn(i-1,j,word1,word2,dp) );


    }
}
