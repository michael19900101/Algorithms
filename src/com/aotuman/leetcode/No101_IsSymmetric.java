package com.aotuman.leetcode;

/**
 * 101.对称二叉树
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * səˈmetrik(ə)l
 */
public class No101_IsSymmetric {

    public static void main(String[] args) {
        No101_IsSymmetric solution = new No101_IsSymmetric();
        TreeNode root = solution.testData();
        boolean res = solution.isSymmetric(root);
        System.out.println(res);
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    // 递归方式
    // 对称条件：
    // 左子树的左孩子 = 右子树的右孩子
    // 左子树的右孩子 = 右子树的左孩子
    public boolean check(TreeNode leftTree, TreeNode rightTree){
        if (leftTree == null && rightTree == null) return true;
        if (leftTree == null || rightTree == null) return false;
        return leftTree.val == rightTree.val
                && check(leftTree.left, rightTree.right)
                && check(leftTree.right, rightTree.left);
    }

    public TreeNode testData() {
        TreeNode rootNode = new TreeNode(1);
        rootNode.left = new TreeNode(2);
        rootNode.right = new TreeNode(2);
        rootNode.left.left = new TreeNode(3);
        rootNode.left.right = new TreeNode(4);
        rootNode.right.left = new TreeNode(4);
        rootNode.right.right = new TreeNode(3);
        return rootNode;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() { }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
