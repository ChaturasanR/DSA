
/**
 * You are given a binary tree represented by root A. You need to check if it is
 * a Binary Search Tree or not.
 * 
 * Assume a BST is defined as follows:
 * 
 * 1) The left subtree of a node contains only nodes with keys less than the
 * node's key.
 * 
 * 2) The right subtree of a node contains only nodes with keys greater than the
 * node's key.
 * 
 * 3) Both the left and right subtrees must also be binary search trees.
 * 
 * Solution:
 * Opt-1:
 * 1. Inorder traversal gives the vals in the sorted order. If the vals are not
 * in sorted order => Not a valid BT. T.C: O(N), S.C:O(N)
 * 
 * Opt-2
 * 1. Use the property of BST
 * 2. LST values < root val < RST vals
 * 3. so LST values restricted by [-inf, root val], root is restricted by [-inf,
 * inf], RST is restricted by [root val, inf]
 * 4. If any node violates this property then it is not a valid BST
 * 
 * T.C: O(N), S.c: O(H)
 */
public class BSTValidator {

    public boolean isValidBST(TreeNode root) {
        return validateBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validateBSTUtil(TreeNode root, int lowerBound, int upperBound) {
        if (root == null)
            return true;

        if (root.val < lowerBound || root.val > upperBound)
            return false;

        return validateBSTUtil(root.left, lowerBound, root.val - 1)
                && validateBSTUtil(root.right, root.val + 1, upperBound);
    }
}
