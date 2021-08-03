package com.aotuman.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *
 * 地图分析(海洋最近陆地距离的集合中最远的距离)
 *
 * 你现在手里有一份大小为N x N 的 网格 grid，上面的每个 单元格 都用0和1标记好了。其中0代表海洋，1代表陆地，
 * 请你找出一个海洋单元格，这个海洋单元格到离它最近的陆地单元格的距离是最大的。
 *
 * 我们这里说的距离是「曼哈顿距离」（Manhattan Distance）：(x0, y0) 和(x1, y1)这两个单元格之间的距离是|x0 - x1| + |y0 - y1|。
 *
 * 如果网格上只有陆地或者海洋，请返回-1。
 */
public class No1162_MaxDistance {

    public static void main(String[] args) {
        No1162_MaxDistance solution = new No1162_MaxDistance();
        int[][] grid = {{1,0,0},{0,0,0},{0,0,0}};
        int res = solution.maxDistance(grid);
        System.out.println(res);
    }

    // 判断坐标 (r, c) 是否在网格中
    public boolean inArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length
                && 0 <= c && c < grid[0].length;
    }

    // https://leetcode-cn.com/problems/as-far-from-land-as-possible/solution/tao-lu-da-jie-mi-gao-dong-ti-mu-kao-cha-shi-yao-sh/
    public int maxDistance(int[][] grid) {
        int rowLength = grid.length, colLength = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        // 将所有的陆地格子加入队列
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        // 如果地图上只有陆地或者海洋，返回 -1
        if (queue.isEmpty() || queue.size() == rowLength * colLength) {
            return -1;
        }

        int[][] moves = {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1},
        };

        // 由于BFS的第一层遍历是从陆地开始，因此遍历完第一层之后distance应该是0
        int distance = -1; // 记录当前遍历的层数（距离）
        while (!queue.isEmpty()) {
            distance++;
            // 当前层的元素有多少，在该轮中一次性遍历完当前层
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                // BFS遍历的当前元素永远是队列的开头元素
                int[] node = queue.poll();
                int r = node[0];
                int c = node[1];
                // 对当前元素的各个方向进行搜索
                for (int[] move : moves) {
                    int r2 = r + move[0];
                    int c2 = c + move[1];
                    // 如果搜索到的新坐标在范围内/是海洋/没有遍历过，则放入队列继续搜索
                    if (inArea(grid, r2, c2) && grid[r2][c2] == 0) {
                        // 把grid中搜索过的元素设置为2
                        grid[r2][c2] = 2;
                        // 放入队列中
                        queue.add(new int[]{r2, c2});
                    }
                }
            }
        }
        // 最终走了多少层才把海洋遍历完
        return distance;
    }
}
