package rudy.dsa.DynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class PathWithMaxGold {

    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        boolean[][]vis = new boolean[m][n];
        for(int i = 0; i<m ; i++){
            for(int j =0; j<n; j++){
                if(grid[i][j]!=0 & !vis[i][j]){
                    int collect =  maxCollect(i , j ,grid , vis , m , n);
                    ans = Math.max(ans , collect);
                }
            }
        }
        return ans;
    }

    private int maxCollect(int row , int col , int[][]grid, boolean[][]vis, int m , int n){
        vis[row][col]= true;
        int max = 0;
        int[]dx={-1,0,0,1};
        int []dy = {0,1,-1,0};

        for(int move = 0; move<4; move++){
            int nR = row + dx[move];
            int nC = col + dy[move];
            int collectedSoFar = grid[row][col];
            if(isValid(grid, vis, m, n, nR, nC)) {
                collectedSoFar +=  maxCollect(nR, nC, grid, vis, m, n);

            }
            max = Math.max(max,collectedSoFar);

        }
        vis[row][col]= false;
        return max;
    }

    private static boolean isValid(int[][] grid, boolean[][] vis, int m, int n, int nR, int nC) {
        return nR >= 0 && nR < m && nC >= 0 && nC < n && !vis[nR][nC] && grid[nR][nC] != 0;
    }

    public static void main(String[] args) {
        /*[[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]*/
//        int[][]grid = {{1,0,7},
//                {2,0,6},
//                {3,4,5},{0,3,0},{9,0,20}};

        int [][]grid= {{0,6,0}, {5,8,7} , {0,9,0}};

        PathWithMaxGold obj = new PathWithMaxGold();
        System.out.println(obj.getMaximumGold(grid));

        Map<Integer, Integer>map = new HashMap<>();
        map.put(1,null);
        Set<Integer>set  = new HashSet<>();
        set.add(null);


        System.out.println(map.get(null));

    }
}
