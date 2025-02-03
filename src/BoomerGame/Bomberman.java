package BoomerGame;

import java.util.*;

class BoomerGame {
    private int rows, cols, seconds;
    private char[][] grid;
    private int[][] timer;

    public BoomerGame(int rows, int cols, int seconds, List<String> initialGrid) {
        this.rows = rows;
        this.cols = cols;
        this.seconds = seconds;
        this.grid = new char[rows][cols];
        this.timer = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            grid[i] = initialGrid.get(i).toCharArray();
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 'O') timer[i][j] = 3;
            }
        }
    }

    public void simulate() {
        for (int t = 1; t <= seconds; t++) {
            if (t % 2 == 0) plantBombs(t + 3);
            else if (t % 3 == 0) detonateBombs();
        }
        printGrid();
    }

    private void plantBombs(int detonationTime) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '.') {
                    grid[i][j] = 'O';
                    timer[i][j] = detonationTime;
                }
            }
        }
    }

    private void detonateBombs() {
        char[][] newGrid = new char[rows][cols];
        for (char[] row : newGrid) Arrays.fill(row, '.');

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 'O' && timer[i][j] == 3) {
                    newGrid[i][j] = '.';
                    if (i > 0) newGrid[i - 1][j] = '.';
                    if (i < rows - 1) newGrid[i + 1][j] = '.';
                    if (j > 0) newGrid[i][j - 1] = '.';
                    if (j < cols - 1) newGrid[i][j + 1] = '.';
                }
            }
        }
        grid = newGrid;
    }

    private void printGrid() {
        for (char[] row : grid) {
            System.out.println(new String(row));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int R = scanner.nextInt();
        int C = scanner.nextInt();
        int S = scanner.nextInt();
        scanner.nextLine();

        List<String> initialGrid = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            initialGrid.add(scanner.nextLine());
        }

        BoomerGame game = new BoomerGame(R, C, S, initialGrid);
        game.simulate();
    }
}
