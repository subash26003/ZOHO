package Arrays;

import java.util.Arrays;

public class NKnights {
    static boolean isValidPosition(char[][] board , int row , int col){
       int[] dx = {-2 , -2 , - 1 , -1};
       int[] dy = {-1 , 1 , -2, 2};

        for (int i = 0; i < 4; i++) {
            int rowPlace = row + dx[i];
            int colPlace = col + dy[i];

            if(rowPlace >= 0 && colPlace >= 0 && colPlace < board.length){
                if(board[rowPlace][colPlace] == 'K') return false;
            }
        }
        return true;
    }
     static boolean placeKnights(char[][] board , int row , int col){
        if(row == board.length) return true;

        if(col >= board.length) {
            row = row + 1;
            col = 0;
        }
        if(isValidPosition(board , row ,col)){
            board[row][col]= 'K';
            if(placeKnights(board , row , col + 1)) return true;
            board[row][col] = '-';
        }
        return placeKnights(board , row , col + 1);
    }
    public static void main(String[] args) {
        int n = 5;
        char[][] board = new char[5][5];
        for(char[] i : board){
            Arrays.fill(i, '-');
        }

        for(char[] i : board){
            System.out.println(Arrays.toString(i));
        }
        placeKnights(board ,0 ,0);

        for(char[] i : board){
            System.out.println(Arrays.toString(i));
        }
    }
}
