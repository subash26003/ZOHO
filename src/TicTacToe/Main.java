package TicTacToe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = 3;
        TicTacToe game = new TicTacToe(3 , 3);
        int i = 1;
        game.printBoard();

        System.out.println("Start the game");
        Scanner scan = new Scanner(System.in);
        while(true){
            if(i % 2 == 0){
                System.out.println("X trun !! Enter the place (i , j)");
                int x = scan.nextInt();
                int y = scan.nextInt();
                game.setCross(x , y);
                game.printBoard();
                if(game.checkWin(x , y, 'X')){
                    System.out.println("X Won!!!");
                    break;
                };
            }else{
                System.out.println("O trun !! Enter the place (i , j)");
                int x = scan.nextInt();
                int y = scan.nextInt();
                game.setCircle(x , y);
                game.printBoard();
                if(game.checkWin(x , y, 'O')){
                    System.out.println("O Won!!!");
                    break;
                };
            }
            i++;
        }
    }
}
