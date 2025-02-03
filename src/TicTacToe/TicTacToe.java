package TicTacToe;

import java.util.Arrays;

public class TicTacToe {
     int row;
     int col;

     char[][] board;
    public TicTacToe(int row , int col) {
        this.row = row;
        this.col = col;
        intialize(this.row , this.col);
    }

    void intialize(int row , int col){
        this.board = new char[row][col];
    }

    boolean checkWin(int x , int y , char ch){
        int count = 0;
        for(int i = 0 ; i < this.row ; i++){
            if(board[x][i] == ch ) count++;
        }
        if(count == 3) return true;
        count = 0;

        for(int i = 0 ; i < this.row ; i++){
            if(board[i][y] == ch ) count++;
        }
        if(count == 3) return true;
        count = 0;

        if(x == 0 && y == 0){
            for(int i = 0 ; i < row ; i++){
                if(board[x + i][y + i] == ch) count++;
            }
        }
        if(count == 3) return true;

        count = 0;

        if(x == row - 1 && y == row -1){
            for (int i = row - 1; i >= 0; i--) {
                if(board[x-i][y-i] == ch )  count++;
            }
        }
        if(count == 3) return true;
        count = 0;

        if(x == row - 1 && y == 0){
            for (int i = 0; i < row; i++) {
                if(board[x-i][y+i] == ch ) count++;
            }
        }
        if(count == 3) return true;
        count = 0;

        if(x == 0 && y == row -1){
            for (int i = row - 1; i >= 0; i--) {
                if(board[x+i][y-i] == ch ) count++;
            }
        }
        if(count == 3) return true;
        return false;

    }
    void setCross(int x , int y){
        board[x][y] = 'X';
    }

    void setCircle(int x , int y){
        this.board[x][y] = 'O';
    }

    void printBoard(){
        for (char[] i : board) {
            System.out.println(Arrays.toString(i));
        }
    }
}
