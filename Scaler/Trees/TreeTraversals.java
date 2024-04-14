import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversals {
    // Traverse left subtree
    // visit the node
    // Traverse right subtree
    // T.C: O(N), S.C: O(H) - All nodes are visited only once,
    // logN (balanced tree) <= H <= N (skewed tree)
    // DFS traversal
    public int[] inOrderRecursive(TreeNode root) {
        List<Integer> inOrderTraversalVals = new ArrayList<>();
        inOrderUtil(root, inOrderTraversalVals);
        return inOrderTraversalVals.stream().mapToInt(Integer::intValue).toArray();
    }

    private void inOrderUtil(TreeNode root, List<Integer> inOrderTraversalVals) {
        if (root == null)
            return;

        // traverse left sub tree
        inOrderUtil(root.left, inOrderTraversalVals);

        // visit node
        inOrderTraversalVals.add(root.val);

        // traverse right sub tree
        inOrderUtil(root.right, inOrderTraversalVals);
    }

    // T.C: O(N), S.C: O(H)
    public int[] inOrderIterative(TreeNode root) {
        List<Integer> inOrderTraversalVals = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }

            curr = st.pop();
            inOrderTraversalVals.add(curr.val);
            curr = curr.right;

        }
        return inOrderTraversalVals.stream().mapToInt(Integer::intValue).toArray();
    }

    // Go level by level
    // 1. Add curr node to queue
    // 2. Until queue is empty follow below steps
    // a. get the curr level size
    // b. iterate on the range of curr level size and pop the node from queue and
    // call it as curr
    // c. check if left node of curr is null if not add it to queue
    // d. check if right node of curr is null if not add it to queue

    // BFS algo
    // T.C: O(N), S.C: O(levelSize) => O(N+1/2) => O(N)
    public int[][] levelOrderTraversal(TreeNode root) {
        if (root == null)
            return new int[][] {};

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> levelOrderTraversalVals = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int currLevelSize = queue.size();
            List<Integer> currLevelVals = new ArrayList<>();
            while (currLevelSize-- > 0) {
                TreeNode curr = queue.poll();
                currLevelVals.add(curr.val);
                if (curr.left != null)
                    queue.add(curr.left);

                if (curr.right != null)
                    queue.add(curr.right);
            }
            levelOrderTraversalVals.add(currLevelVals);
        }
        return convertArrayListTo2DArray(levelOrderTraversalVals);

    }

    private int[][] convertArrayListTo2DArray(List<List<Integer>> lists) {
        return lists.stream().map(list -> list.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
    }

    // Another version of level order traversal using null as delimiter
    public int[][] levelOrderTraversal2(TreeNode root) {
        if (root == null)
            return new int[][] {};

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> levelOrderTraversalVals = new ArrayList<>();
        queue.add(root);
        queue.add(null);
        List<Integer> currLevelVals = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                if (!queue.isEmpty())
                    queue.add(null);
                levelOrderTraversalVals.add(currLevelVals);
                currLevelVals = new ArrayList<>();
                continue;
            }

            currLevelVals.add(curr.val);
            if (curr.left != null)
                queue.add(curr.left);
            if (curr.right != null)
                queue.add(curr.right);

        }
        return convertArrayListTo2DArray(levelOrderTraversalVals);

    }

    // visit the node
    // Traverse left subtree
    // Traverse right subtree
    // T.C: O(N), S.C: O(H) - All nodes are visited only once,
    // logN (balanced tree) <= H <= N (skewed tree)
    // DFS traversal
    public int[] preOrderRecursive(TreeNode root) {
        List<Integer> preOrderTraversalVals = new ArrayList<>();
        preOrderUtil(root, preOrderTraversalVals);
        return preOrderTraversalVals.stream().mapToInt(Integer::intValue).toArray();
    }

    private void preOrderUtil(TreeNode root, List<Integer> preOrderTraversalVals) {
        if (root == null)
            return;

        // visit node
        preOrderTraversalVals.add(root.val);

        // traverse left sub tree
        preOrderUtil(root.left, preOrderTraversalVals);

        // traverse right sub tree
        preOrderUtil(root.right, preOrderTraversalVals);
    }

    public int[] preOrderIterative(TreeNode root) {
        List<Integer> preOrderTraversalVals = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode curr = st.pop();
            preOrderTraversalVals.add(curr.val);
            if (curr.right != null)
                st.push(curr.right);
            if (curr.left != null)
                st.push(curr.left);
        }
        return preOrderTraversalVals.stream().mapToInt(Integer::intValue).toArray();
    }

    // Traverse left subtree
    // Traverse right subtree
    // visit the node
    // T.C: O(N), S.C: O(H) - All nodes are visited only once,
    // logN (balanced tree) <= H <= N (skewed tree)
    // DFS traversal
    public int[] postOrderRecursive(TreeNode root) {
        List<Integer> postOrderTraversalVals = new ArrayList<>();
        postOrderUtil(root, postOrderTraversalVals);
        return postOrderTraversalVals.stream().mapToInt(Integer::intValue).toArray();
    }

    private void postOrderUtil(TreeNode root, List<Integer> postOrderTraversalVals) {
        if (root == null)
            return;

        // traverse left sub tree
        postOrderUtil(root.left, postOrderTraversalVals);

        // traverse right sub tree
        postOrderUtil(root.right, postOrderTraversalVals);

        // visit node
        postOrderTraversalVals.add(root.val);
    }

    // TODO: Add logic for post order iterative
    public int[] postOrderIterative(TreeNode root) {
        return new int[] {};
    }

    /**
     * Problem Description
     * Given a binary tree, return the values of its boundary in anti-clockwise
     * direction starting from the root. Boundary includes left boundary, leaves,
     * and right boundary in order without duplicate nodes.
     * 
     * Left boundary is defined as the path from the root to the left-most node.
     * Right boundary is defined as the path from the root to the right-most node.
     * 
     * If the root doesn't have left subtree or right subtree, then the root itself
     * is left boundary or right boundary. Note this definition only applies to the
     * input binary tree, and not applies to any subtrees.
     * 
     * The left-most node is defined as a leaf node you could reach when you always
     * firstly travel to the left subtree if exists. If not, travel to the right
     * subtree. Repeat until you reach a leaf node.
     * 
     * The right-most node is also defined by the same way with left and right
     * exchanged.
     * 
     * Return an array of integers denoting the boundary values of tree in
     * anti-clockwise order.
     * 
     * Solution
     * 1. First visit left view nodes except for the last level
     * 2. Then visit leaf nodes
     * 3. Then visit right nodes from bottom to up except the last level
     * 
     * T.C: O(N + H + H) = O (N), S.C: O(H)
     */
    public int[] boundaryTraversal(TreeNode root) {
        if (root == null)
            return new int[] {};

        List<Integer> boundaryVals = new ArrayList<>();
        boundaryVals.add(root.val);
        leftBoundaryTraversal(root.left, boundaryVals);
        traverseLeaves(root, boundaryVals);
        rightBoundaryTraversal(root.right, boundaryVals);
        return boundaryVals.stream().mapToInt(Integer::intValue).toArray();
    }

    private void rightBoundaryTraversal(TreeNode root, List<Integer> boundaryVals) {
        if (root == null)
            return;

        // skipping the leaf nodes
        if (root.left == null && root.right == null)
            return;

        // Traverse towards the right subtree if not go to left
        if (root.right != null)
            rightBoundaryTraversal(root.right, boundaryVals);
        else if (root.left != null)
            rightBoundaryTraversal(root.left, boundaryVals);

        boundaryVals.add(root.val);
    }

    private void traverseLeaves(TreeNode root, List<Integer> boundaryVals) {
        if (root == null)
            return;

        // traverse the leaf nodes
        if (root.left == null && root.right == null) {
            boundaryVals.add(root.val);
        }

        traverseLeaves(root.left, boundaryVals);
        traverseLeaves(root.right, boundaryVals);
    }

    private void leftBoundaryTraversal(TreeNode root, List<Integer> boundaryVals) {
        if (root == null)
            return;

        // skipping the leaf nodes
        if (root.left == null && root.right == null)
            return;

        boundaryVals.add(root.val);

        // Traverse towards the left subtree if not go to right
        if (root.left != null)
            leftBoundaryTraversal(root.left, boundaryVals);
        else if (root.right != null)
            leftBoundaryTraversal(root.right, boundaryVals);
    }
}
