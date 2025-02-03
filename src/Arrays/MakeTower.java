package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MakeTower {
    static boolean getBlocks(int[] arr ,ArrayList<Integer> ans , int index , int h , int sum , int count){
        if (count > 3 || sum > h) return false;
        if (count == 3 && sum == h) return true;

        for (int i = index; i < arr.length; i++) {
            ans.add(arr[i]);
            if (getBlocks(arr, ans, i + 1, h, sum + arr[i], count + 1)) {
                return true;
            }
            ans.remove(ans.size() - 1); // Backtracking
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1,2, 4 , 5 , 3, 6};
        int h1 = 6, h2 = 15;
        ArrayList<Integer> ans = new ArrayList<>();
        getBlocks(arr , ans , 0 , h1, 0 , 0);
        System.out.println(ans);
        ans.clear();
        getBlocks(arr , ans , 0 , h2 , 0 , 0);
        System.out.println(ans);
    }
}
