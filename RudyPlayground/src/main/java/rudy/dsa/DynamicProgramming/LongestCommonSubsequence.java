package rudy.dsa.DynamicProgramming;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();
        Integer[][] dp = new Integer[n + 1][m + 1];
        return lcs(n - 1, m - 1, text1, text2, dp);

    }


    private int lcs(int i, int j, String s1, String s2, Integer[][] dp) {
        if (i < 0 || j < 0)
            return 0;
        if (dp[i][j] != null)
            return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = 1 + lcs(i - 1, j - 1, s1, s2, dp);

        return dp[i][j] = Math.max(lcs(i - 1, j, s1, s2, dp), lcs(i, j - 1, s1, s2, dp));

    }
}
