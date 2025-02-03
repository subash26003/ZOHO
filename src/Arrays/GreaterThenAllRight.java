package Arrays;

import java.util.Arrays;
import java.util.Stack;

public class GreaterThenAllRight {
    public static void main(String[] args) {
        int[] arr = {16,  17 , 4 , 3 , 5 , 2};

        Stack<Integer> s = new Stack<>();
        int max = Integer.MIN_VALUE;
        for(int i = arr.length - 1 ; i >= 0 ; i--){
            if(max < arr[i]){
                System.out.println(arr[i]);
                max = arr[i];
            }
        }
        StringBuilder a = new StringBuilder();
        

        System.out.println(s);
    }
}
