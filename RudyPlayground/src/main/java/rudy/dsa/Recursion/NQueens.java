package rudy.dsa.Recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens {

    public static List < List < String >> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<>();
        boolean []horizontal = new boolean[(2*n)-1];
        boolean []upperDiag = new boolean[(2*n)-1];
        boolean []lowerDiag = new boolean[(2*n)-1];
        dfs(0, board, res,horizontal,upperDiag,lowerDiag);
        return res;
    }

    static boolean validate(char[][] board, int row, int col) {
        int duprow = row;
        int dupcol = col;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q') return false;
            col--;
            row++;
        }
        return true;
    }

    //This is an optimized soltn using extra space refer validate method for brute force way
    static void dfs(int col, char[][] board, List < List < String >> res, boolean[] horizontal, boolean[] upperDiag, boolean[] lowerDiag) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
           if( !horizontal[row] && !lowerDiag[row+col] && !upperDiag[board.length-1+col-row]){
               board[row][col] = 'Q';
               horizontal[row]=true;
               lowerDiag[row-col]=true;
               upperDiag[board.length-1+col+row]=true;
               dfs(col + 1, board, res, horizontal, upperDiag, lowerDiag);
               board[row][col] = '.';
               horizontal[row]=false;
               lowerDiag[row+col]=false;
               upperDiag[board.length-1+col-row]=false;
           }
        }
    }



    static List< String > construct(char[][] board) {
        List < String > res = new LinkedList< String >();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

}
