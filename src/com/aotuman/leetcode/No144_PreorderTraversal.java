package com.aotuman.leetcode;

import java.util.*;

/**
 * 二叉树的前序遍历（递归、迭代）
 *
 * 描述：
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * Output: [1,2,3]
 */
public class No144_PreorderTraversal {

    public static void main(String[] args) {
        No144_PreorderTraversal solution = new No144_PreorderTraversal();
        TreeNode root = solution.testData();
        solution.preorderTraversal(root);
//        solution.preorderTraversal2(root);
    }

    /**
     * 一、递归方式
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversal(root, res);
        return res;
    }

    public void preorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
    }


    /**
     * 二、迭代方式
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                // 根节点入栈
                stack.push(root);
                // 根节点值保存到结果集合
                res.add(root.val);
                // 左子节点作为根节点遍历下一层
                root = root.left;
            }
            // 找不到左子节点，先把上一层的左子节点出栈，
            // rootNode指向上一层的左子节点，开始找rootNode的右子节点
            root = stack.pop();
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
