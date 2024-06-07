import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeViews {

    class NodeLevelPair {
        private TreeNode node;
        private int level;

        public NodeLevelPair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }

        public TreeNode getNode() {
            return this.node;
        }

        public int getLevel() {
            return this.level;
        }
    }

    /**
     * Problem Description
     * Given a binary tree of integers. Return an array of integers representing the
     * left view of the Binary tree.
     * 
     * Left view of a Binary Tree is a set of nodes visible when the tree is visited
     * from Left side
     * 
     * NOTE: The value comes first in the array which have lower level.
     * 
     * Solution:
     * 1. Apply level order traversal
     * 2. Pick the first value of each level
     * 
     * T.C: O(N), S.C: O(N)
     */
    public int[] leftView(TreeNode root) {
        if (root == null)
            return new int[] {};

        List<List<Integer>> levelOrderTraversalVals = levelOrderTraversal(root);
        int[] leftViewVals = new int[levelOrderTraversalVals.size()];
        for (int i = 0; i < levelOrderTraversalVals.size(); i++) {
            leftViewVals[i] = levelOrderTraversalVals.get(i).get(0);
        }
        return leftViewVals;
    }

    /**
     * Given a binary tree of integers denoted by root A. Return an array of
     * integers representing the right view of the Binary tree.
     * 
     * Right view of a Binary Tree is a set of nodes visible when the tree is
     * visited from Right side.
     * 
     * Solution:
     * 1. Apply level order traversal
     * 2. Pick the last value of each level
     * 
     * T.C: O(N), S.C: O(N)
     */
    public int[] rightView(TreeNode root) {
        if (root == null)
            return new int[] {};

        List<List<Integer>> levelOrderTraversalVals = levelOrderTraversal(root);
        int[] rightViewVals = new int[levelOrderTraversalVals.size()];
        for (int i = 0; i < levelOrderTraversalVals.size(); i++) {
            List<Integer> currLevelVals = levelOrderTraversalVals.get(i);
            rightViewVals[i] = currLevelVals.get(currLevelVals.size() - 1);
        }
        return rightViewVals;
    }

    private List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> levelOrderTraversalVals = new ArrayList<>();
        if (root == null)
            return levelOrderTraversalVals;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<Integer> currLevelVals = new ArrayList<>();
        while (queue.size() > 1) {
            TreeNode curr = queue.poll();
            if (curr == null) {
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

        if (currLevelVals.size() > 0)
            levelOrderTraversalVals.add(currLevelVals);

        return levelOrderTraversalVals;
    }

    /**
     * Problem Description
     * Given a binary tree of integers denoted by root A. Return an array of
     * integers representing the top view of the Binary tree.
     * 
     * The top view of a Binary Tree is a set of nodes visible when the tree is
     * visited from the top.
     * 
     * Return the nodes in any order.
     * 
     * Solution:
     * 1. For top view and bottom view, vertical order traversal is needed
     * 2. So consider vertical level of root is 0 and if we move left decrease by 1
     * and if we move to right increase by 1
     * 3. Store the list of nodes vs level in a hashmap
     * 4. Use level order traversal
     * 
     * T.C: O(N), S.c: O(N)
     */
    public int[] topView(TreeNode root) {
        if (root == null)
            return new int[] {};

        Map<Integer, List<Integer>> levelNodesMapping = new HashMap<>();
        verticalLevelOrder(root, levelNodesMapping);

        List<List<Integer>> verticalLevelOrderValues = new ArrayList<>();
        int minLevel = Integer.MAX_VALUE, maxLevel = Integer.MIN_VALUE;
        for (Integer level : levelNodesMapping.keySet()) {
            minLevel = Math.min(minLevel, level);
            maxLevel = Math.max(maxLevel, level);
        }

        for (int i = minLevel; i <= maxLevel; i++) {
            verticalLevelOrderValues.add(new ArrayList<>(levelNodesMapping.get(i)));
        }

        return verticalLevelOrderValues.stream().mapToInt(list -> list.get(0)).toArray();
    }

    public int[] bottomView(TreeNode root) {
        if (root == null)
            return new int[] {};

        Map<Integer, List<Integer>> levelNodesMapping = new HashMap<>();
        verticalLevelOrder(root, levelNodesMapping);

        List<List<Integer>> verticalLevelOrderValues = new ArrayList<>();
        int minLevel = Integer.MAX_VALUE, maxLevel = Integer.MIN_VALUE;
        for (Integer level : levelNodesMapping.keySet()) {
            minLevel = Math.min(minLevel, level);
            maxLevel = Math.max(maxLevel, level);
        }

        for (int i = minLevel; i <= maxLevel; i++) {
            verticalLevelOrderValues.add(new ArrayList<>(levelNodesMapping.get(i)));
        }

        return verticalLevelOrderValues.stream().mapToInt(list -> list.get(list.size() - 1)).toArray();
    }

    private void verticalLevelOrder(TreeNode root, Map<Integer, List<Integer>> levelNodesMapping) {
        if (root == null)
            return;

        Queue<NodeLevelPair> queue = new LinkedList<>();
        queue.add(new NodeLevelPair(root, 0));
        queue.add(null);

        while (queue.size() > 1) {
            NodeLevelPair curr = queue.poll();

            if (curr == null) {
                queue.add(null);
                continue;
            }

            TreeNode currNode = curr.getNode();

            if (!levelNodesMapping.containsKey(curr.getLevel()))
                levelNodesMapping.put(curr.getLevel(), new ArrayList<>());

            levelNodesMapping.get(curr.getLevel()).add(currNode.val);
            if (currNode.left != null) {
                queue.add(new NodeLevelPair(currNode.left, curr.getLevel() - 1));
            }

            if (currNode.right != null) {
                queue.add(new NodeLevelPair(currNode.right, curr.getLevel() + 1));
            }
        }
    }
}
