package Arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PossiblePaths implements Cloneable{

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    static int findPaths(int[][] grid , int x , int y , int dx , int dy){
        if(x >= grid.length || y >= grid[0].length || x < 0 || y < 0 || grid[x][y] == 0){
            return 0;
        }
        if(x == dx && y == dy){
            return 1;
        }
        grid[x][y] = 0;
        int down =   findPaths(grid , x + 1, y , dx , dy);
        int up = findPaths(grid , x - 1, y , dx , dy) ;
        int right =  findPaths(grid , x, y + 1 , dx , dy);
        int  left  = findPaths(grid , x, y - 1 , dx , dy);
        grid[x][y] = 1;
        return  down + up + right + left ;
    }

    static void findMinmum(int[][] grid , int x , int y , int dx , int dy , ArrayList<String> comb, ArrayList<String> ans){
        if(x >= grid.length || y >= grid[0].length || x < 0 || y < 0 || grid[x][y] == 0){
            return ;
        }
        if(x == dx && y == dy){
            if(ans.isEmpty() && !comb.isEmpty()){
                ans.addAll(comb);
            }else{
                if(ans.size() > comb.size()){
                    ans.clear();
                    ans.addAll(comb);
                }
            }
            return ;
        }
        grid[x][y] = 0;
        comb.add("D");
        findMinmum(grid , x + 1, y , dx , dy , comb , ans);
        comb.remove("D");
        comb.add("U");
        findMinmum(grid , x - 1, y , dx , dy,comb , ans) ;
        comb.remove("U");
        comb.add("R");
        findMinmum(grid , x, y + 1 , dx , dy,comb, ans);
        comb.remove("R");

        comb.add("L");
        findMinmum(grid , x, y - 1 , dx , dy,comb , ans);
        comb.remove("L");

        grid[x][y] = 1;
    }
    public static void main(String[] args)throws CloneNotSupportedException {
        int[][] grid = {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };

//        Scanner scan = new Scanner(System.in);
//        int x = scan.nextInt();
//        int y = scan.nextInt();
//
//        int dX = scan.nextInt();
//        int dY = scan.nextInt();
        ArrayList<String> ans = new ArrayList<>();
        findMinmum(grid ,2 , 0 , 1 , 2 , new ArrayList<String>() ,ans );

        System.out.println(ans);
//        System.out.println(findPaths(grid , 2 , 0 , 1 , 2));
    }
}
