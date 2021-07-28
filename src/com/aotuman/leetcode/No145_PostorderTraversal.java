package com.aotuman.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的后序遍历（递归、迭代）
 * 左-右-根
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 */
public class No145_PostorderTraversal {

    public static void main(String[] args) {
        No145_PostorderTraversal solution = new No145_PostorderTraversal();
        TreeNode root = solution.testData();
//        solution.postorderTraversal(root);
        solution.postorderTraversal2(root);
    }

    /**
     * 一、递归方式
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversal(root, res);
        return res;
    }

    public void postorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        postorderTraversal(root.left, list);
        postorderTraversal(root.right, list);
        list.add(root.val);
    }

    /**
     * 二、迭代方式
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果上一层的右子节点是空，或者上一层的右子节点等于之前记录过的值
            if (root.right == null || root.right == prev) {
                // 记录左子节点的值
                res.add(root.val);
                prev = root;
                // root赋值为空，让stack继续弹出值
                root = null;
            } else {
                // 上一层的root重新入栈，并将root节点指向上一层的右子节点
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

    public TreeNode testData() {
        TreeNode rootNode = new TreeNode(1);
        rootNode.left = null;
        rootNode.right = new TreeNode(2);
        rootNode.right.left = new TreeNode(3);
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
