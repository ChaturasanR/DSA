import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeAndDeserialize {
    /**
     * Problem Description
     * Given the root node of a Binary Tree denoted by A. You have to Serialize the
     * given Binary Tree in the described format.
     * 
     * Serialize means encode it into a integer array denoting the Level Order
     * Traversal of the given Binary Tree.
     * 
     * NOTE:
     * 
     * In the array, the NULL/None child is denoted by -1.
     * 
     * Solution:
     * 1. Do level order traversal
     * 2. Add both left and right nodes
     * 3. When there is null value popped from queue that means child is null and
     * add -1 to the result
     * 
     * T.C: O(N), S.C: O(N)
     */
    public int[] serialize(TreeNode root) {
        if (root == null)
            return new int[] {};

        List<Integer> serializedVals = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                serializedVals.add(-1);
                continue;
            }

            serializedVals.add(curr.val);
            queue.add(curr.left);
            queue.add(curr.right);
        }
        return serializedVals.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Problem Description
     * You are given an integer array A denoting the Level Order Traversal of the
     * Binary Tree.
     * 
     * You have to Deserialize the given Traversal in the Binary Tree and return the
     * root of the Binary Tree.
     * 
     * NOTE:
     * 
     * In the array, the NULL/None child is denoted by -1.
     * 
     * Solution:
     * We need to track which child belongs to which root
     * so we maintain a queue to add the created nodes
     * 
     * T.C: O(N), S.C: O(N)
     */
    public TreeNode deserialize(int[] arr) {
        if (arr.length == 0)
            return null;

        TreeNode root = new TreeNode(arr[0]);
        if (arr.length == 1)
            return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int idx = 1;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            int leftChildVal = arr[idx++];
            int rightChildVal = arr[idx++];

            if (leftChildVal != -1) {
                curr.left = new TreeNode(leftChildVal);
                queue.add(curr.left);
            }

            if (rightChildVal != -1) {
                curr.right = new TreeNode(rightChildVal);
                queue.add(curr.right);
            }
        }
        return root;
    }
}
