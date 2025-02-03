package Arrays;

import java.util.Arrays;


public class ColorChange {
    public static void main(String[] args) {
        int[][] color =  {{1, 1, 1, 1, 2, 1, 1, 1},
                {1, 1, 1, 1, 2, 1, 0, 0},
                {1, 0, 0, 1, 2, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 3, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
        };

        int x = 4, y = 4, k = 3;
        changeColor(color , x , y , k , color[x][y]);

        for(int[] i : color){
            System.out.println(Arrays.toString(i));
        }
    }

    static void changeColor(int[][] color , int x , int y , int k , int old){
        if(x > color.length -1 || x < 0 || y < 0 || y > color[0].length -1 || color[x][y] != old){
            return;
        }
        color[x][y] = k;
        changeColor(color , x-1 , y , k , old);
        changeColor(color , x + 1, y  , k , old);
        changeColor(color , x , y -1  , k , old);
        changeColor(color , x , y + 1 , k , old);

    }
}
