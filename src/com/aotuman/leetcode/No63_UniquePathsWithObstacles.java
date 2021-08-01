package com.aotuman.leetcode;

/**
 *
 * 不同路径2 (动态规划 + 滚动数组)
 *
 * 描述：
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 例子：
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 *
 */
public class No63_UniquePathsWithObstacles {

    public static void main(String[] args) {
        No63_UniquePathsWithObstacles solution = new No63_UniquePathsWithObstacles();
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int res = solution.uniquePathsWithObstacles2(obstacleGrid);
        System.out.println(res);
    }

    // 时间复杂度：O(M * N)
    // 空间复杂度：O(M * N)
    // https://pic.leetcode-cn.com/1618038337-pKpEHT-5.png
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowLength = obstacleGrid.length, colLength = obstacleGrid[0].length;
        int[][] res = new int[rowLength][colLength];
        // (0,0)这个格子可能有障碍物
        res[0][0] = (obstacleGrid[0][0] == 1)? 0:1;
        // 左边界赋值
        for (int i = 1; i < rowLength; i++) {
            // 错误写法：obstacleGrid[i - 1][0] == 1 XXX  --> res[i - 1][0] == 0
            if (obstacleGrid[i][0] == 1 || res[i - 1][0] == 0) {
                // 当前格子有障碍物，或者上方的路径=0(不能以上一个格子有障碍物作为判断标准，因为可能在这之前就有了障碍物)
                res[i][0] = 0;
            } else {
                res[i][0] = 1;
            }
        }
        // 上边界赋值
        for (int j = 1; j < colLength; j++) {
            // 错误写法：obstacleGrid[0][j - 1] == 1 XXX --> res[0][j - 1] == 0
            if (obstacleGrid[0][j] == 1 || res[0][j - 1] == 0) {
                // 当前格子有障碍物，或者左方的路径=0(不能以左边一个格子有障碍物作为判断标准，因为可能在这之前就有了障碍物)
                res[0][j] = 0;
            } else {
                res[0][j] = 1;
            }
        }
        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j < colLength; j++) {
                // 当前格子有障碍物
                if (obstacleGrid[i][j] == 1) {
                    res[i][j] = 0;
                } else {
                    // 路径总数来自于上方(res[i-1][j])和左方(res[i][j-1])
                    res[i][j] = res[i - 1][j] + res[i][j - 1];
                }
            }
        }
        return res[rowLength - 1][colLength - 1];
    }

    // 滚动数组
    // 时间复杂度：O(M * N)
    // 空间复杂度：O(M)
    // 计算当前值 = 以求出的左边值 + 上一次迭代同位置的值
    // dp[j] = dp[j - 1] + dp[j]
    // https://pic.leetcode-cn.com/1618038876-CvseNW-8.png
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int rowLength = obstacleGrid.length;
        int colLength = obstacleGrid[0].length;
        int[] dp = new int[colLength];
        //起点可能有障碍物
        dp[0] = (obstacleGrid[0][0] == 1) ? 0 : 1;
        for(int i = 0; i < rowLength; i++) {
            for(int j = 0; j < colLength; j++) {
                // 有障碍物的格子直接赋0
                if(obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                }
                // 否则dp[j]的值由左方和上一次迭代的dp[j]累加而来
                // 上一个网格不在上边框上，并且没有障碍物
                else if(obstacleGrid[i][j] == 0 && j - 1 >= 0) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }
        return dp[colLength - 1];
    }
}
