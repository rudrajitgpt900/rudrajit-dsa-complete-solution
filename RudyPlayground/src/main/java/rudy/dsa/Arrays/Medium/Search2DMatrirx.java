package rudy.dsa.Arrays.Medium;

public class Search2DMatrirx {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col= matrix[0].length;

        int i = 0;
        int j= col -1; //last column index

        while(i<row && j>=0){

            if(matrix[i][j]==target)
                return true;

            int curr= matrix[i][j];

            if(curr < target)
                i++;
            else
                j--;


        }
        return false;
    }
}
