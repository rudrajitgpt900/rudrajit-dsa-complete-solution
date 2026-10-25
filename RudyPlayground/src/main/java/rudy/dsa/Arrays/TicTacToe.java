package rudy.dsa.Arrays;

import java.util.Arrays;

public class TicTacToe {

    public static void isWinner(char[][]board, int row, int col, char mark){
        if(row<0 || row>= board.length || col<0 || col>=board.length){
            System.out.println("OUT_OF_BOUNDARY");
            return ;
        }
        if(board[row][col]!='.'){
            System.out.println("PLACE_ALREADY_OCCUPIED "+ "at row:- "+row +" & col:- "+col);
            return ;
        }

        boolean rowWise=true,colWise=true,left=true,right=true;

        board[row][col]=mark;
        //Check row wise
        for(int i=0;i< board.length;i++){
            if(board[row][i]!=mark){
                rowWise=false;
                break;
            }
        }
        //Check col wise
        for (char[] chars : board) {
            if (chars[col] != mark) {
                colWise = false;
                break;
            }
        }
        //Check for left diagonal
        for(int i=0; i< board.length; i++){
            if(board[i][i]!=mark){
                left=false;
                break;
            }
        }
        //Check for right diagonal
        for(int i=0; i< board.length; i++){
            if(board[i][board.length-i-1]!=mark){
                right=false;
                break;
            }
        }
        if(left||right||rowWise||colWise){
            System.out.println("Winning move:: "+ "at row:- "+row +" & col:- "+col);
        }
        else
            System.out.println("Not a Winning move:: "+ "at row:- "+row +" & col:- "+col);
    }

    public static void main(String[] args) {
        char[][]board = new char[][]{
                {'.','.','.'},
                {'.','.','.'},
                {'.','.','.'}
        };

        isWinner(board, 0, 2, 'x');//true (not a winning move)
        isWinner(board, 0, 0, 'o');
        isWinner(board, 2, 2, 'x');
        isWinner(board, 1, 2, 'o');
        isWinner(board, 1, 1, 'x');
        isWinner(board, 2, 3, 'o'); //OUT_OF_BOUND
        isWinner(board, 1, 1, 'o'); //ALREADY_FILLED
        isWinner(board, 1, 0, 'o');
        isWinner(board, 2, 0, 'x'); //false(because this is a winning move)

        for(char []row : board){
            System.out.println(Arrays.toString(row));
        }

    }
}
