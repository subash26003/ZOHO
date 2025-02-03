package Arrays;

import java.util.*;

public class MinGreaterElement {



    static void findMinGreater(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // Traverse from right to left
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            map.put(arr[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(arr[i]);
        }

        // Print the results
        for (int num : arr) {
            System.out.println(num + " -> " + (map.get(num) == -1 ? "" : map.get(num)));
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 1, 8, 5, 11};

        int n = arr.length;
        int[] ans = new int[n];



        for (int i = 0; i < n ; i++) {
            int max = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if(i == j || arr[i] == arr[j]) continue;
                if(arr[i] < arr[j] && arr[j] < max){
                    max = arr[j];
                    ans[i] = arr[j];
                }
            }
        }

        System.out.println(Arrays.toString(ans));
    }
}

