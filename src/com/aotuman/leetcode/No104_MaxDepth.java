package com.aotuman.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度
 *
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明:叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 */
public class No104_MaxDepth {

    public static void main(String[] args) {
        No104_MaxDepth solution = new No104_MaxDepth();
        TreeNode root = solution.testData();
        int res = solution.maxDepth2(root);
        System.out.println(res);
    }

    /**
     * BFS
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            maxDepth++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return maxDepth;
    }

    /**
     * DFS
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        // 1.左孩子和有孩子都为空的情况，说明到达了叶子节点，直接返回1即可
        if(root.left == null && root.right == null) return 1;

        // 2.如果左孩子和由孩子其中一个为空，那么需要返回比较大的那个孩子的深度
        int m = maxDepth2(root.left);
        int n = maxDepth2(root.right);
        if (root.left == null || root.right == null) return m + n + 1;

        // 3.最后一种情况，也就是左右孩子都不为空，返回最大深度+1即可
        return Math.max(m, n) + 1;
    }

    public int te(TreeNode root, int max){
        return 0;
    }

    public TreeNode testData() {
        TreeNode rootNode = new TreeNode(3);
        rootNode.left = new TreeNode(9);
        rootNode.right = new TreeNode(20);
        rootNode.right.left = new TreeNode(15);
        rootNode.right.right = new TreeNode(7)  ;
        return rootNode;
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
