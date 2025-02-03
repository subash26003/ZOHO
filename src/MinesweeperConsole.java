
import java.util.Random;
import java.util.Scanner;

public class MinesweeperConsole {
    private final int GRID_SIZE = 10;
    private final int MINES_COUNT = 15;
    private final char[][] board = new char[GRID_SIZE][GRID_SIZE];
    private final boolean[][] mines = new boolean[GRID_SIZE][GRID_SIZE];
    private boolean gameOver = false;

    public MinesweeperConsole() {
        initializeBoard();
        placeMines();
    }

    private void initializeBoard() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                board[i][j] = '-';
            }
        }
    }

    private void placeMines() {
        Random rand = new Random();
        int placedMines = 0;
        while (placedMines < MINES_COUNT) {
            int x = rand.nextInt(GRID_SIZE);
            int y = rand.nextInt(GRID_SIZE);
            if (!mines[x][y]) {
                mines[x][y] = true;
                placedMines++;
            }
        }
    }

    private void displayBoard() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void handleMove(int x, int y) {
        if (mines[x][y]) {
            System.out.println("Game Over! You hit a mine!");
            gameOver = true;
        } else {
            int count = countAdjacentMines(x, y);
            board[x][y] = (count == 0) ? ' ' : (char) ('0' + count);
        }
    }

    private int countAdjacentMines(int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nx = x + i, ny = y + j;
                if (nx >= 0 && nx < GRID_SIZE && ny >= 0 && ny < GRID_SIZE && mines[nx][ny]) {
                    count++;
                }
            }
        }
        return count;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        while (!gameOver) {
            displayBoard();
            System.out.print("Enter row and column (0-9): ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (x < 0 || x >= GRID_SIZE || y < 0 || y >= GRID_SIZE) {
                System.out.println("Invalid input. Try again.");
                continue;
            }
            handleMove(x, y);
        }
        scanner.close();
    }

    public static void main(String[] args) {
        MinesweeperConsole game = new MinesweeperConsole();
        game.playGame();
    }
}

