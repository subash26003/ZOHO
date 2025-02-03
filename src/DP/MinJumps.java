package DP;
import java.util.*;

public class MinJumps {

    private static int jump(int[] nums, int index, int[] dp) {
        if (index >= nums.length - 1) return 0;
        if (dp[index] != -1) return dp[index];

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[index]; i++) {
            if (index + i >= nums.length) break;
            int nextJump = jump(nums, index + i, dp);
            if (nextJump != Integer.MAX_VALUE) { // Avoid overflow if no solution
                min = Math.min(min, 1 + nextJump);
            }
        }

        dp[index] = min;
        return min;
    }

    public static int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return jump(nums, 0, dp);
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));  // Output: 2
    }
}
