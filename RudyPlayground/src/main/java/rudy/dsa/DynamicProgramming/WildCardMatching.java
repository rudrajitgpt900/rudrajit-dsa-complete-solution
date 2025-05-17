package rudy.dsa.DynamicProgramming;

public class WildCardMatching {

    public boolean isMatch(String text, String pattern) {

        int n = pattern.length();
        int m = text.length();
        Boolean[][]dp = new Boolean[n+1][m+1];
        return fn(n-1,m-1,pattern,text, dp);

    }

    private boolean fn(int i, int j, String pattern, String text, Boolean[][] dp) {

        if(i<0 && j<0)
            return true;
        if(i<0 && j>=0)
            return false;
        if(j<0 && i>=0){
            for(int k = 0; k<=i;k++){
                if(pattern.charAt(k)!='*')
                    return false;
            }
            return true;
        }

        if(dp[i][j]!=null)
            return dp[i][j];

        if(pattern.charAt(i)==text.charAt(j) || pattern.charAt(i)=='?')
            return dp[i][j]=fn(i-1,j-1,pattern,text, dp);
        if(pattern.charAt(i)=='*')
            return dp[i][j]=fn(i-1,j,pattern,text, dp) || fn(i,j-1, pattern,text, dp);

        return dp[i][j]=false;
    }


}
