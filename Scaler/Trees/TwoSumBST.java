import java.util.Stack;

/**
 * Problem Description
 * Given a binary search tree A, where each node contains a positive integer,
 * and an integer B, you have to find whether or not there exist two different
 * nodes X and Y such that X.value + Y.value = B.
 * 
 * Return 1 to denote that two such nodes exist. Return 0, otherwise.
 * 
 * Solution:
 * Approach 1: Store the inorder traversal in arr and apply two pointer => T.C:
 * O(N), S.C:O(N)
 * Approach 2: Try to apply two pointers while traversing the tree
 * 1. This is not feasible using recursion (as it involves traversing back) so
 * iterative is the way
 * 2. Two pointers, leftPointer pointing to first inorder val and rightPointer
 * pointing to last inorder val
 * a. if (leftPointval + rightPointerVal == given_sum) return true;
 * b. if (leftPointval + rightPointerVal < given_sum) move leftPointer to its
 * successor
 * c. else move rightPointer to it predecessory
 * 
 * T.C: O(N), S.C: O(H)
 * 
 */
public class TwoSumBST {

    // T.C: O(N), S.C: O(H)
    public boolean doesTwoNodesExistWithGivenSum(TreeNode root, int sumVal) {
        if (root == null)
            return false;

        Stack<TreeNode> leftPointerStack = new Stack<>();
        Stack<TreeNode> rightPointerStack = new Stack<>();

        TreeNode leftPointer = root;
        addLeftPointerNodesToStack(leftPointerStack, leftPointer);

        TreeNode rightPointer = root;
        addRightPointerNodesToStack(rightPointerStack, rightPointer);

        leftPointer = leftPointerStack.pop();
        rightPointer = rightPointerStack.pop();

        while (leftPointer.val < rightPointer.val) {
            int twoNodesSum = leftPointer.val + rightPointer.val;
            if (twoNodesSum == sumVal)
                return true;
            if (twoNodesSum < sumVal) {
                leftPointer = leftPointer.right;
                addLeftPointerNodesToStack(leftPointerStack, leftPointer);
                leftPointer = leftPointerStack.pop();
            } else {
                rightPointer = rightPointer.left;
                addRightPointerNodesToStack(rightPointerStack, rightPointer);
                rightPointer = rightPointerStack.pop();
            }
        }
        return false;
    }

    private void addRightPointerNodesToStack(Stack<TreeNode> rightPointerStack, TreeNode rightPointer) {
        while (rightPointer != null) {
            rightPointerStack.push(rightPointer);
            rightPointer = rightPointer.right;
        }
    }

    private void addLeftPointerNodesToStack(Stack<TreeNode> leftPointerStack, TreeNode leftPointer) {
        while (leftPointer != null) {
            leftPointerStack.push(leftPointer);
            leftPointer = leftPointer.left;
        }
    }

}
