package Arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ShuffleArray {
    static  int randValue(){
        return (int)Math.floor(Math.random()*2);
    }
    static void shuffle(Integer[] arr){
        Arrays.sort(arr , (a , b) -> randValue() == 1 ? a-b : b-a);
    }

    static void shuffleInPlace(int[] arr){
        Random rand = new Random();
        for(int i = arr.length - 1; i > 0  ; i--){
            int j = rand.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    static void formArray(int[] arr , int start , int end){
        arr[0] = start;
        for (int i = 1 ; i <= end - start ; i++) {
            arr[i] = arr[i-1] + 1;
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int test = s.nextInt();
        for (int i = 0; i < test; i++) {
            int start = s.nextInt();
            int end = s.nextInt();

            int[] arr = new int[end - start + 1];
            formArray(arr , start , end);
            System.out.println(Arrays.toString(arr));
            shuffleInPlace(arr);
            System.out.println(Arrays.toString(arr));
        }
    }
}
