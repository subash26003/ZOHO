import java.util.Arrays;

public class SuddokoGame {
    static boolean valid(int[][] grid , int num , int row , int col){
        for (int i = 0; i < grid[0].length; i++) {
            if(grid[row][i] == num) return false;
        }

        for (int i = 0; i < grid.length; i++) {
            if(grid[i][col] == num) return false;
        }

        int innerRowStart = (row / 3) * 3;
        int innerColStart = (col / 3) * 3;

        for(int i = innerRowStart ; i < innerRowStart + 3 ; i++){
            for (int j = innerColStart; j < innerColStart + 3; j++) {
                if(grid[i][j] == num) return false;
            }
        }
        return true;
    }

    static boolean solveSuddoko(int[][] grid){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == -1){
                    for (int k = 1; k <= 9; k++) {
                        if(valid(grid , k , i , j)){
                            grid[i][j] = k;
                            if(solveSuddoko(grid)) return true;
                            grid[i][j] = -1;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] grid = {
                {5, 3, -1, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, -1, 5, 3, 4, 8},
                {1, 9, 8, -1, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, -1, 4, 2, 3},
                {4, -1, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, -1, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, -1, 8, 4},
                {2, 8, -1, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, -1, 9}
        };

        solveSuddoko(grid);
        for(int[] i : grid){
            System.out.println(Arrays.toString(i));
        }


    }
}
