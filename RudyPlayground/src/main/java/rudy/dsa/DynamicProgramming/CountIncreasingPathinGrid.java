package rudy.dsa.DynamicProgramming;

public class CountIncreasingPathinGrid {

    public static final int MOD = (int)1e9+7;
    public static final int[][]dir = {{-1,0},{1,0},{0,1},{0,-1}};
    public int countPaths(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        int prev = -1;
        Integer[][]dp = new Integer[m][n];
        for(int i =0; i<m; i++){
            for(int j = 0 ; j<n; j++){
               ans+= dfs(i,j, grid,m,n, prev , dp);
            }
        }

        return ans;
    }

    private int dfs(int i, int j, int[][] grid, int m, int n , int prev, Integer[][] dp) {

        //base case
        if(i<0 || i>= m || j<0 ||j>=n || grid[i][j]<=prev)
            return 0;
        if(dp[i][j]!= null)
            return dp[i][j];
        int path = 1;
        for(int []arr : dir){
            path+= (dfs(i+arr[0], j+arr[1], grid, m , n , grid[i][j], dp)) % MOD;
        }
        return dp[i][j]= path % MOD;
    }
}
