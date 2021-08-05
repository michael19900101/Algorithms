package com.aotuman.leetcode;

/**
 * 70. 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 */
public class No70_ClimbStairs {

    public static void main(String[] args) {
        No70_ClimbStairs solution = new No70_ClimbStairs();
        int res = solution.climbStairs2(3);
        System.out.println(res);
    }

    /**
     * 方法一：递归
     * 时间复杂度 O(2^n) 2^n个节点
     * 空间复杂度 O(n) 二叉树的深度（递归栈的数量）
     */
    public int climbStairs1(int n){
        if (n == 0 || n == 1) return  1;
        if (n == 2) return  2;
        return climbStairs1(n-1) + (n-2);
    }

    /**
     * 方法二：记忆化递归
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public int climbStairs2(int n){
        int[] mem = new int[n+1]; // 储存中间结果，避免重复计算
        return climbStairsMemory(n, mem);
    }

    public int climbStairsMemory(int n, int[] mem){
        if (mem[n] > 0) return mem[n];
        if (n == 0 || n == 1) return  1;
        if (n == 2) return  2;
        return climbStairsMemory(n-1, mem) + climbStairsMemory(n-2, mem);
    }

    /**
     * 方法三：滚动数组
     */
    public int climbStairs3(int n){
        int first = 0, second = 0, third = 1;
        for (int i = 0; i < n; i++) {
            first = second;
            second = third;
            third = first + second;
        }
        return third;
    }


}
