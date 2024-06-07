/**
 * Problem Description
 * Given a root of binary tree A, determine if it is height-balanced.
 * 
 * A height-balanced binary tree is defined as a binary tree in which the depth
 * of the two subtrees of every node never differ by more than 1.
 * 
 * Solution:
 * 1. we need to check for height of left subtree and right subtree
 * 2. If their difference is should be <= 1 for balanced BT
 * 
 * T.C: O(N), S.c: O(H)
 */
public class BalancedBinaryTree {
    boolean isBalanced = true;

    public boolean isBalancedBT(TreeNode root) {
        if (root == null)
            return true;
        boolean isBalancedBT = true;
        height(root);
        return isBalancedBT;
    }

    private int height(TreeNode root) {
        if (root == null)
            return -1;

        int lHeight = height(root.left);
        int rHeight = height(root.right);

        if (Math.abs(lHeight - rHeight) > 1)
            isBalanced = false;

        return Math.max(lHeight, rHeight) + 1;
    }
}
