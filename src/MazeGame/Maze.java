//package MazeGame;
//
//import java.text.Normalizer;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class Maze {
//    static ArrayList<Character> smallestPath;
//    int row;
//    int col;
//char[][] maze;
//int[][] trigger;
//    public Maze(int row, int col, int[][] trigger) {
//        this.row = row;
//        this.col = col;
//        this.maze = new char[row][col];
//        this.trigger = trigger;
//        iniatializeMaze();
//    }
//
//    private void iniatializeMaze(){
//        System.out.println(this.row + " " + this.col);
//        for(int i = 0 ; i < this.row ; i++){
//            for (int j = 0; j < this.col; j++) {
//                this.maze[i][j] = '0';
//            }
//        }
//    }
//
//
//    void setTreasure(int Trow , int Tcol){
//        this.maze[--Trow][--Tcol] = 'T';
//    }
//    void setAdventure(int Trow , int Tcol){
//        this.maze[--Trow][--Tcol] = 'A';
//    }
//    void setMonster(int Mrow , int Mcol){
//        this.maze[--Mrow][--Mcol] = 'M';
//    }
//
//    private static class  Node{
//        int x;
//        int y ;
//        int steps;
//        Node previous;
//        Node(int x, int y, int steps , Node pre) {
//            this.x = x;
//            this.y = y;
//            this.steps = steps;
//            this.previous = pre;
//        }
//    }
//    char getDirection(Node current , Node previous){
//        if(current.x == previous.x && current.y > previous.y){
//            return 'R';
//        }else if(current.x == previous.x && current.y < previous.y){
//            return 'L';
//        }else if(current.x > previous.x && current.y == previous.y){
//            return 'D';
//        }else{
//            return 'U';
//        }
//    }
//
//    private  void printPath(Node current){
//        StringBuilder path = new StringBuilder();
//        Node c = current;
//        while (!(c.previous == null)){
//            path.append(getDirection(c , c.previous));
//            c = c.previous;
//        }
//        System.out.println(path.reverse());
//        while (!(current == null)){
//            maze[current.x][current.y] = 'P';
//            current = current.previous;
//        }
//        for(char[] i : maze){
//            System.out.println(Arrays.toString(i));
//        }
//    }
//
//    boolean isTriggerAvailable( Node curr){
//
//        for(int[] i : trigger){
//            if(curr.x == i[0] - 1 && curr.y == i[1] - 1){
//                return true;
//            }
//        }
//        return false;
//    }
//
//
//     int getShortestPath(char[][] grid ,int initailRow , int initailCol){
//        initailRow--; initailCol--;
//
//        int mazeRowSize = grid.length;
//        int mazeColSize = grid[0].length;
//        boolean[][] visited = new boolean[mazeRowSize][mazeColSize];
//
//        Queue<Node> q = new LinkedList<>();
//        q.add(new Node(initailRow , initailCol , 0 , null));
//        int[][] directions = {{1,0} ,{-1,0} , {0,1} , {0,-1}};
//        visited[initailRow][initailCol] = true;
//        while(!q.isEmpty()){
//            Node currentNode = q.poll();
//
//            for(int i = 0 ; i < directions.length ; i++){
//
//                int nextRow = currentNode.x + directions[i][0];
//                int nextCol = currentNode.y + directions[i][1];
//
//                if(nextRow >= 0 && nextRow < mazeRowSize && nextCol >= 0 && nextCol < mazeColSize && !visited[nextRow][nextCol] &&
//                        ( grid[nextRow][nextCol] != 'M')){
//                    if(isTriggerAvailable(currentNode)){
//
//                    }
//                    if(grid[nextRow][nextCol] == 'T'){
//                        Node nextNode = new Node(nextRow , nextCol , currentNode.steps + 1, currentNode);
//                        printPath(nextNode);
//                        return nextNode.steps;
//                    }
//                    Node nextNode = new Node(nextRow, nextCol , currentNode.steps + 1 , currentNode);
//                    q.add(nextNode);
//                    visited[nextRow][nextCol] = true;
//                }
//            }
//
//
//        }
//        return -1;
//
//    }
//
//
//}
package MazeGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    static ArrayList<Character> smallestPath;
    int row;
    int col;
    char[][] maze;
    int[][] trigger;

    public Maze(int row, int col, int[][] trigger) {
        this.row = row;
        this.col = col;
        this.maze = new char[row][col];
        this.trigger = trigger;
        initializeMaze();
    }

    private void initializeMaze(){
        System.out.println(this.row + " " + this.col);
        for(int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                this.maze[i][j] = '0';
            }
        }
    }

    void setTreasure(int Trow, int Tcol){
        this.maze[--Trow][--Tcol] = 'T';
    }

    void setAdventure(int Trow, int Tcol){
        this.maze[--Trow][--Tcol] = 'A';
    }

    void setMonster(int Mrow, int Mcol){
        this.maze[--Mrow][--Mcol] = 'M';
    }

    private static class Node{
        int x;
        int y;
        int steps;
        Node previous;

        Node(int x, int y, int steps, Node pre) {
            this.x = x;
            this.y = y;
            this.steps = steps;
            this.previous = pre;
        }
    }

    char getDirection(Node current, Node previous){
        if(current.x == previous.x && current.y > previous.y) {
            return 'R';
        } else if(current.x == previous.x && current.y < previous.y) {
            return 'L';
        } else if(current.x > previous.x && current.y == previous.y) {
            return 'D';
        } else {
            return 'U';
        }
    }

    private void printPath(Node current) {
        StringBuilder path = new StringBuilder();
        Node c = current;
        while (c.previous != null) {
            path.append(getDirection(c, c.previous));
            c = c.previous;
        }
        System.out.println(path.reverse());
        while (current != null) {
            maze[current.x][current.y] = 'P';
            current = current.previous;
        }
        for (char[] i : maze) {
            System.out.println(Arrays.toString(i));
        }
    }

    boolean isTriggerAvailable(Node curr){
        for (int[] triggerPoint : trigger) {
            if (curr.x == triggerPoint[0] - 1 && curr.y == triggerPoint[1] - 1) {
                return true;
            }
        }
        return false;
    }

    void handleTrigger(Node curr) {
        // Logic for what happens when a trigger is activated
        System.out.println("Trigger activated at: (" + (curr.x + 1) + ", " + (curr.y + 1) + ")");
        // For example, change some maze content or unlock a path.
        maze[curr.x][curr.y] = 'X'; // Marking the trigger point as 'X' (could be any logic).
    }

    int getShortestPath(char[][] grid, int initialRow, int initialCol) {
        initialRow--; initialCol--; // Adjusting for 0-based indexing

        int mazeRowSize = grid.length;
        int mazeColSize = grid[0].length;
        boolean[][] visited = new boolean[mazeRowSize][mazeColSize];

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(initialRow, initialCol, 0, null));
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // Down, Up, Right, Left
        visited[initialRow][initialCol] = true;

        while (!q.isEmpty()) {
            Node currentNode = q.poll();

            // Check if trigger is available and handle it
            if (isTriggerAvailable(currentNode)) {
                handleTrigger(currentNode); // Activate the trigger (e.g., unlocking a door)
            }

            for (int[] direction : directions) {
                int nextRow = currentNode.x + direction[0];
                int nextCol = currentNode.y + direction[1];

                if (nextRow >= 0 && nextRow < mazeRowSize && nextCol >= 0 && nextCol < mazeColSize && !visited[nextRow][nextCol] &&
                        (grid[nextRow][nextCol] != 'M')) {

                    if (grid[nextRow][nextCol] == 'T') {
                        Node nextNode = new Node(nextRow, nextCol, currentNode.steps + 1, currentNode);
                        printPath(nextNode);
                        return nextNode.steps;
                    }

                    Node nextNode = new Node(nextRow, nextCol, currentNode.steps + 1, currentNode);
                    q.add(nextNode);
                    visited[nextRow][nextCol] = true;
                }
            }
        }
        return -1; // No path found
    }
}
