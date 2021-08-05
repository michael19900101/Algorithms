package com.aotuman.leetcode;

public class No70_ClimbStairs {

    public static void main(String[] args) {
        No70_ClimbStairs solution = new No70_ClimbStairs();
        solution.climbStairs(3);
    }

    public int climbStairs(int n){
        if (n == 0 || n == 1) return 1;
        int res = 0, p = 0, q = 0;
        for (int i = 1; i < n + 1; i++) {
            p = i;
            q = i - 1;
            res = p + q;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
