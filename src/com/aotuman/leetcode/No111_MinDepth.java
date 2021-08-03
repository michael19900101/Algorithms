package com.aotuman.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 二叉树的最小深度
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 */
public class No111_MinDepth {

    public static void main(String[] args) {
        No111_MinDepth solution = new No111_MinDepth();
        TreeNode root = solution.testData();
        int res = solution.minDepth(root);
        System.out.println(res);
    }

    public TreeNode testData() {
        TreeNode rootNode = new TreeNode(3);
        rootNode.left = new TreeNode(9);
        rootNode.right = new TreeNode(20);
        rootNode.right.left = new TreeNode(15);
        rootNode.right.right = new TreeNode(7);
        return rootNode;
    }

    /**
     * BFS 广度优先 队列
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int minDepth = 0;
        while (!queue.isEmpty()) {
            minDepth ++;
            int size = queue.size();
            // 当前层的元素有多少，在该轮中一次性遍历完当前层
            for (int i = 0; i < size; i++) {
                // BFS遍历的当前元素永远是队列的开头元素
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return minDepth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

        }
        return minDepth;
    }

    /**
     * DFS 深度优先 递归
     */
    public int minDepth2(TreeNode root) {
        if(root == null) return 0;
        // 这道题递归条件里分为三种情况
        // 1.左孩子和有孩子都为空的情况，说明到达了叶子节点，直接返回1即可
        if(root.left == null && root.right == null) return 1;
        // 2.如果左孩子和由孩子其中一个为空，那么需要返回比较大的那个孩子的深度
        int m1 = minDepth2(root.left);
        int m2 = minDepth2(root.right);
        // 这里其中一个节点为空，说明m1和m2有一个必然为0，所以可以返回m1 + m2 + 1;
        if (root.left == null || root.right == null) return m1 + m2 + 1;

        // 3.最后一种情况，也就是左右孩子都不为空，返回最小深度+1即可
        return Math.min(m1,m2) + 1;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
