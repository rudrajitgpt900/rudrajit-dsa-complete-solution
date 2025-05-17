package rudy.dsa.DynamicProgramming;

import java.util.*;

public class MSFT2 {

    public int solution(String[] board)
    {
        int n = board.length;
        int m = board[0].length();

        // Create prefix arrays to store count of 'A' and 'B'
        int[][] prefixA = new int[n + 1][m + 1];
        int[][] prefixB = new int[n + 1][m + 1];

        // Calculate prefix sums for 'A' and 'B'
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefixA[i][j] = prefixA[i - 1][j] + prefixA[i][j - 1] - prefixA[i - 1][j - 1];
                prefixB[i][j] = prefixB[i - 1][j] + prefixB[i][j - 1] - prefixB[i - 1][j - 1];
                if (board[i - 1].charAt(j - 1) == 'A') {
                    prefixA[i][j]++;
                } else if (board[i - 1].charAt(j - 1) == 'B') {
                    prefixB[i][j]++;
                }
            }
        }

        int count = 0;

        // Iterate over each possible bottom-right corner of the submatrix
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = i; k <= n; k++) {
                    for (int l = j; l <= m; l++) {
                        int countA = prefixA[k][l] - prefixA[i - 1][l] - prefixA[k][j - 1] + prefixA[i - 1][j - 1];
                        int countB = prefixB[k][l] - prefixB[i - 1][l] - prefixB[k][j - 1] + prefixB[i - 1][j - 1];
                        if (countA == countB) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }







    public static void main(String[] args) {
        MSFT2 o = new MSFT2();
        String[]grid = {"AB.", "B..", "..A"}; //expected 5

        String[]x ={"A.", "AB"};////expected 0
        String[]y ={"...A", "...A", "...A"}; ////expected 9
        System.out.println(o.solution(grid));


    }
}
