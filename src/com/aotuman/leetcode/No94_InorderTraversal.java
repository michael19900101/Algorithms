package com.aotuman.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历（递归、迭代）
 * 左-根-右
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 */
public class No94_InorderTraversal {

    public static void main(String[] args) {
        No94_InorderTraversal solution = new No94_InorderTraversal();
        TreeNode root = solution.testData();
        solution.inorderTraversal(root);
//        solution.inorderTraversal2(root);
    }

    /**
     * 一、递归方式
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        return res;
    }

    public void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

    /**
     * 二、迭代方式
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                // 根节点入栈
                stack.push(root);
                // 左子节点作为根节点遍历下一层
                root = root.left;
            }
            // 找不到左子节点，先把上一层的左子节点出栈，
            // rootNode指向上一层的左子节点，开始找rootNode的右子节点
            root = stack.pop();
            // 根节点值（上一层的左子节点）保存到结果集合
            res.add(root.val);
            // 右子节点作为根节点遍历下一层
            root = root.right;
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
