package DP;

import java.util.*;

public class Fib {
    static int fib(int n , int[] dp){
        if(n <= 1) return n;
        if(dp[n] != -1) return dp[n];
        int f = fib(n-1 , dp) + fib(n - 2, dp);
        dp[n] = f;
        return f;
    }
    public static void main(String[] args) {
        int n = 10;
        int[] dp = new int[n+1];
        Arrays.fill(dp , -1);
        System.out.println(fib(n , dp));
        Map<Integer , Integer> map = new HashMap<>();
        map.put(1 , 1);
        map.put(2 , 2);
        System.out.println(map.get(new Random().nextInt(map.size())));
        List<Integer> nums = new ArrayList<>();
        nums.add(2);
        System.out.println(nums);
    }
}
