
/**
 * Problem Description
 * Given an array where elements are sorted in ascending order, convert it to a
 * height Balanced Binary Search Tree (BBST).
 * 
 * Balanced tree : a height-balanced binary tree is defined as a binary tree in
 * which the depth of the two subtrees of every node never differ by more than
 * 
 * 
 * Solution:
 * To maintain the balanced binary tree. Pick the middle element as root and
 * divide the left to root as left subtee and right to root as right subtree
 * 
 * T.C: O(N), S.C: O(logN)
 */
public class BSTConverter {

    public TreeNode convert(int[] arr) {
        if (arr.length == 0)
            return null;

        return divideAndBuildTree(arr, 0, arr.length - 1);
    }

    private TreeNode divideAndBuildTree(int[] arr, int start, int end) {
        if (start > end)
            return null;

        int mid = start + (end - start) / 2;

        TreeNode root = new TreeNode(arr[mid]);
        root.left = divideAndBuildTree(arr, start, mid - 1);
        root.right = divideAndBuildTree(arr, mid + 1, end);
        return root;
    }
}
