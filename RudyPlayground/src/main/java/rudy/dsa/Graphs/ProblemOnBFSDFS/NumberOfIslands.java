package rudy.dsa.Graphs.ProblemOnBFSDFS;
//Leetcode 200
//Given an m x n 2D binary grid ,grid which represents a map of '1's (land) and '0's (water), return the number of islands.
//
//An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
// You may assume all four edges of the grid are all surrounded by water.
public class NumberOfIslands {

    public int numIslands(char[][] grid) {

        int noOfIslands =0;
        int n= grid.length;
        int m = grid[0].length;
        boolean [][] visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' &&!visited[i][j]){
                    dfs(grid,i,j,visited ,n ,m);
                    noOfIslands++;
                }
            }
        }

        return noOfIslands;

    }

    private void dfs(char[][] grid, int row, int col, boolean[][] visited, int n, int m) {
        visited[row][col] = true;
        int[][]dirs= new int[][]{{-1,0} , {1,0} , {0,-1} , {0,1}};
        for(int travel = 0; travel<4; travel++){
            int newRow = row + dirs[travel][0];
            int newCol = col + dirs[travel][1];
            if(isValid(newRow,newCol,n,m,visited,grid)){
                dfs(grid,newRow,newCol,visited,n,m);
            }
        }
    }

    private boolean isValid(int row, int col, int n, int m, boolean[][] visited, char[][] grid) {
        return row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == '1' && !visited[row][col];
    }


}
