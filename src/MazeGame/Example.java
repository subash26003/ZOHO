package MazeGame;
//import java.util.*;
//
//class MazeGame {
//    static final int SIZE = 10;
//    static char[][] grid = {
//            {'.', '.', '.', 'M', '.', '.', 'H', '.', '.', '.'},
//            {'.', 'H', '.', '.', 'M', '.', '.', 'H', '.', '.'},
//            {'.', '.', 'M', '.', '.', 'H', '.', '.', 'M', '.'},
//            {'H', '.', '.', '.', 'H', '.', '.', 'M', '.', '.'},
//            {'.', '.', '.', '.', '.', 'M', '.', '.', 'H', '.'},
//            {'.', 'M', '.', 'H', '.', '.', 'M', '.', '.', '.'},
//            {'.', '.', '.', '.', 'H', '.', '.', 'M', '.', 'T'},
//            {'.', '.', 'H', '.', '.', 'G', '.', '.', 'H', '.'},
//            {'A', '.', '.', 'M', '.', 'H', '.', '.', '.', '.'},
//            {'.', '.', '.', 'G', 'M', '.', '.', 'M', '.', '.'}
//    };
//    static int adventurerX = 8, adventurerY = 0;
//    static int treasureX = 6, treasureY = 9;
//    static boolean hasTrigger = false;
//    static final char EMPTY = '.', ADVENTURER = 'A', TREASURE = 'T', MONSTER = 'M', HOLE = 'H', TRIGGER = 'G';
//
//    public static void main(String[] args) {
//        findShortestPath();
//    }
//
//    static void findShortestPath() {
//        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[]{adventurerX, adventurerY, 0});
//        boolean[][] visited = new boolean[SIZE][SIZE];
//        visited[adventurerX][adventurerY] = true;
//
//        while (!queue.isEmpty()) {
//            int[] current = queue.poll();
//            int x = current[0], y = current[1], steps = current[2];
//
//            if (grid[x][y] == TREASURE) {
//                System.out.println("Shortest path to treasure: " + steps);
//                return;
//            }
//            if (grid[x][y] == TRIGGER) {
//                hasTrigger = true;
//            }
//
//            for (int[] dir : directions) {
//                int newX = x + dir[0];
//                int newY = y + dir[1];
//
//                if (isValidMove(newX, newY, visited)) {
//                    visited[newX][newY] = true;
//                    queue.add(new int[]{newX, newY, steps + 1});
//                }
//
//                if (hasTrigger && canShoot(x, y, dir)) {
//                    shootMonster(x, y, dir);
//                }
//            }
//        }
//        System.out.println("No path to the treasure found!");
//    }
//
//    static boolean isValidMove(int x, int y, boolean[][] visited) {
//        return x >= 0 && y >= 0 && x < SIZE && y < SIZE && !visited[x][y] && grid[x][y] != MONSTER && grid[x][y] != HOLE;
//    }
//
//    static boolean canShoot(int x, int y, int[] dir) {
//        int newX = x + dir[0], newY = y + dir[1];
//        while (newX >= 0 && newY >= 0 && newX < SIZE && newY < SIZE) {
//            if (grid[newX][newY] == MONSTER) {
//                return true;
//            }
//            if (grid[newX][newY] == HOLE) {
//                break;
//            }
//            newX += dir[0];
//            newY += dir[1];
//        }
//        return false;
//    }
//
//    static void shootMonster(int x, int y, int[] dir) {
//        int newX = x + dir[0], newY = y + dir[1];
//        while (newX >= 0 && newY >= 0 && newX < SIZE && newY < SIZE) {
//            if (grid[newX][newY] == MONSTER) {
//                grid[newX][newY] = EMPTY;
//                System.out.println("Shot a monster at (" + newX + ", " + newY + ")");
//                break;
//            }
//            if (grid[newX][newY] == HOLE) {
//                break;
//            }
//            newX += dir[0];
//            newY += dir[1];
//        }
//    }
//}

