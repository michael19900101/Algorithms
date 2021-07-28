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
//        List<Integer> list = new ArrayList<>();
//        solution.preorderTraversal(root, list);

        solution.preorderTraversal2(root);
    }

    /**
     * 递归方式
     */
    public List<Integer> preorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return list;
        list.add(root.val);
        if (root.left != null) {
            preorderTraversal(root.left, list);
        }
        if (root.right != null) {
            preorderTraversal(root.right, list);
        }
        return list;
    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }


    /**
     * 迭代方式
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode rootNode = root;
        while (!stack.isEmpty() || rootNode != null) {
            while (rootNode != null) {
                // 根节点入栈
                stack.push(rootNode);
                // 根节点值保存到结果集合
                res.add(rootNode.val);
                // 左子节点作为根节点遍历下一层
                rootNode = rootNode.left;
            }
            // 找不到左子节点，先把左子节点出栈，父亲节点作为根节点，开始找右子节点
            rootNode = stack.pop();
            // 右子节点作为根节点遍历下一层
            rootNode = rootNode.right;
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
