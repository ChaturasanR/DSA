public class BST {

    // follow BST property
    // T.C: O(H)
    public boolean search(TreeNode root, int val) {
        if (root == null)
            return false;

        TreeNode temp = root;
        while (temp != null) {
            if (temp.val == val)
                return true;

            if (temp.val > val) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return false;
    }

    // T.C: O(H), S.C: O(H)
    public TreeNode delete(TreeNode root, int val) {
        if (root == null)
            return root;

        if (root.val == val) {
            // leaf node => delete directly
            if (root.left == null && root.right == null)
                return null;

            // node with one child => attach the curr node child to curr node parent
            if (root.left == null || root.right == null) {
                if (root.left != null)
                    return root.left;
                return root.right;
            }

            // two children => find inorder successor/predecessor and replace the curr node
            // with that that and delete the val at replaced location
            int inOrderSuccessorVal = minVal(root.right);
            root.val = inOrderSuccessorVal;
            root.right = delete(root.right, inOrderSuccessorVal);
            return root;
        }

        if (root.val < val) {
            root.right = delete(root.right, val);
        } else {
            root.left = delete(root.left, val);
        }
        return root;
    }

    private int minVal(TreeNode root) {
        int minVal = root.val;
        while (root != null) {
            minVal = Math.min(minVal, root.val);
            root = root.left;
        }
        return minVal;
    }

    // nodes are inserted at the leaf node
    // T.C: O(H), S.C: O(H)
    public TreeNode insert(TreeNode root, int val) {
        if (root == null)
            return null;

        TreeNode parent = null;
        TreeNode temp = root;
        while (temp != null) {
            parent = temp;
            if (temp.val == val)
                return root;
            if (temp.val < val)
                temp = temp.right;
            else
                temp = temp.left;
        }

        TreeNode newNode = new TreeNode(val);
        if (val < parent.val) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        return parent;
    }
}
