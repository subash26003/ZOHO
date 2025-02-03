package MazeGame;

import java.util.Arrays;
import java.util.Scanner;

public class MazeMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the maze Row size and Col Size");
        int r = scan.nextInt();
        int c= scan.nextInt();
        int[][] trigger = {{3 ,2} , {1 ,3}};
        Maze maze = new Maze(r , c , trigger);
        System.out.println("Enter the Tresure Location");
        int TR = scan.nextInt();
        int TC = scan.nextInt();
        maze.setTreasure(TR , TC);
        for(char[] i : maze.maze){
            System.out.println(Arrays.toString(i));
        }
        System.out.println("Enter No of Monster");
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the Monster Location");
            int Mx = scan.nextInt();
            int My = scan.nextInt();

            maze.setMonster(Mx , My);
        }


        System.out.println("Enter the current Location");
        int x = scan.nextInt();
        int y = scan.nextInt();
        maze.setAdventure(x,y);
        for(char[] i : maze.maze){
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
        int path = maze.getShortestPath(maze.maze, x , y);
        System.out.println(path);

    }
}
