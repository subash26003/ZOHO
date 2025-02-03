package SnackeGame;

import javax.crypto.ExemptionMechanism;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Example {
    static Queue<int[]> snack = new LinkedList<>();
    static{
        snack.add(new int[]{0,0});
    }
    static int[] pre = {0 , 0};
    static int currentX = 0;
    static int currentY = 0;

    static void increaseSize(char[][] board, int nextX , int nextY){
        int[] p = {nextX , nextY};
        board[nextX][nextY] = '.';
        Example.currentX = nextX;
        Example.currentY = nextY;
        snack.add(p);
    }

    static void moveSnack(char[][] board , int nextX , int nextY){
        int[] tail = snack.poll();
        board[tail[0]][tail[1]] = board[nextX][nextY];
        board[nextX][nextY] = '.';
        int[] p = {nextX,nextY};
        Example.currentX = nextX;
        Example.currentY = nextY;
        snack.add(p);
    }

    static boolean bitCheck(char[][] board , int nextX , int nextY){
        return board[nextX][nextY] == '.';
    }

    static boolean InvalidMove(char[][] board , int nextX , int nextY){
        return nextX >= 0 && nextY >= 0 && nextX < board.length && nextY < board[0].length && (pre[0] != nextX || pre[1] != nextY) ;
    }

    static boolean moveTheSnack(char[][] board , char move , int currX , int currY){
        int nextX = currX , nextY = currY;
        if(move == 'D') nextX++;
        if(move == 'U') nextX--;
        if(move == 'L') nextY--;
        if(move == 'R') nextY++;

        if(!InvalidMove(board , nextX , nextY)){
            System.out.println("Invalid Move");
            return true;
        }
        if(bitCheck(board , nextX , nextY)) return false;

        if(board[nextX][nextY] == 'X'){
            increaseSize(board ,nextX ,nextY);
        }else{
            moveSnack(board , nextX , nextY);
        }
        pre = new int[]{currX , currY};
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[8][8];

        board[0][0] = '.';
        board[2][2] = 'X';
        board[1][2] = 'X';
        board[5][3] = 'X';
        board[4][0] = 'X';

        for(char[] i : board){
            System.out.println(Arrays.toString(i));
        }
        Scanner scan = new Scanner(System.in);

        while(true){
            System.out.print("Enter the move (D,U,R,L) : ");
            char move = Character.toUpperCase(scan.nextLine().charAt(0));
            if(move == 'E'){
                System.out.println("Exit");
                break;
            }
            if(move == 'U' || move == 'D' || move == 'R' || move == 'L'){
                boolean status = moveTheSnack(board , move , currentX , currentY);
                if(status){
                    for (char[] i : board) {
                        System.out.println(Arrays.toString(i));
                    }
                }else{
                    System.out.println("GAME OVER");
                    break;
                }
            }else {
                System.out.println("Enter the correct value");
            }



        }

    }
}
