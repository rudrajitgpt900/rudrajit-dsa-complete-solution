package rudy.dsa.Arrays.Medium;

public class MatrixRotate {
    public void rotate(int[][] a) {

        int n = a.length;
        int m= a[0].length;

        //Transpose
        for(int i=0;i<n;i++){
            for(int j=i;j<m;j++){
                if(i==j)
                    continue;
                else{
                    int temp= a[i][j];
                    a[i][j]= a[j][i];
                    a[j][i]= temp;
                }
            }
        }

        //Reverse each row of given matrix
        for (int[] currRow : a) {
            swap(currRow, 0, currRow.length - 1);
        }

    }
    private static void swap(int[] currRow, int start, int end) {

        while(start<end){
            int temp = currRow[start];
            currRow[start]= currRow[end];
            currRow[end]= temp;
            start++;
            end--;
        }
    }
}
