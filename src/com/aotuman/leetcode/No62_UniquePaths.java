package com.aotuman.leetcode;

/**
 *
 * 不同路径
 *
 * 描述：
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 *
 * 示例：
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 *
 * 思路：动态规划
 * 转移方程：f(i,j)=f(i−1,j)+f(i,j−1)
 *
 * 杨辉三角：
 * 每个位置的路径 = 该位置左边的路径 + 该位置右边的路径
 *
 */
public class No62_UniquePaths {

    public static void main(String[] args) {
        No62_UniquePaths solution = new No62_UniquePaths();
        int m = 3;
        int n = 2;
        int res = solution.uniquePaths(m, n);
        System.out.println(res);
    }

    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        // 第一行和第一列在边界，所以只能为1，
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }
}
