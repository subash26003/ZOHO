package Patterns;

import java.util.ArrayList;
import java.util.Arrays;

public class OneTwos {
    public static void main(String[] args) {
        int n = 5;  // Number of rows, you can change n for different outputs

        // Loop to create each row
        for (int i = 1; i <= n; i++) {
            // Loop to print the numbers in the row
            for (int j = 1; j <= i; j++) {
                // Print alternating 1 and 2
                if (j % 2 != 0) {
                    System.out.print("1 ");
                } else {
                    System.out.print("2 ");
                }
            }
            // Move to the next line after printing each row
            System.out.println();
            ArrayList<Integer> ans = new ArrayList<>();
            
        }
    }
}
