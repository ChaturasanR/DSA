public class ConstructBinaryTree {
    /**
     * Given the inorder and postorder traversal of a tree, construct the binary
     * tree.
     * 
     * NOTE: You may assume that duplicates do not exist in the tree.
     * 
     * Sol:
     * 1. postorder ends with root, find the root in inorder. The nodes to left in
     * order belong to left sub tree and other half belong to right sub tree
     * 2. The left sub tree will be of same length in postorder as well. Again
     * repeat
     * step until tree is constructed
     * 
     * T.C: O(N^2), S.C: O(H)
     */
    public TreeNode btFromInorderAndPostorder(int[] inorder, int[] postorder) {
        return btFromInorderAndPostorderUtil(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode btFromInorderAndPostorderUtil(int[] inorder, int[] postorder, int inStart, int inEnd,
            int postStart,
            int postEnd) {

        // base condn
        if (postStart > postEnd)
            return null;

        // create the root for the current subtree
        TreeNode root = new TreeNode(postorder[postEnd]);

        // find the idx of the current subtree root in inorder array
        int inRootIdx = findRootIdx(inorder, inStart, inEnd, root.val);
        // if val not found return null
        if (inRootIdx == -1)
            return null;

        // create left subtree for current subtree
        // Nodes from inStart to inRootIdx - 1 => left subtree
        // Nodes from postStart to postStart + leftSubTreeLen - 1
        root.left = btFromInorderAndPostorderUtil(inorder, postorder, inStart, inRootIdx - 1, postStart,
                postStart + inRootIdx - inStart - 1);

        // create right subtree for current subtree
        // Nodes from inRootIdx + 1 to inEnd => left subtree
        // Nodes from postStart + leftSubTreeLen to postEnd-1 as postEnd is root node
        root.right = btFromInorderAndPostorderUtil(inorder, postorder, inRootIdx + 1, inEnd,
                postStart + inRootIdx - inStart,
                postEnd - 1);
        return root;
    }

    private int findRootIdx(int[] inorder, int inStart, int inEnd, int val) {
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == val)
                return i;
        }
        return -1;
    }

    /**
     * Problem Description
     * Given preorder and inorder traversal of a tree, construct the binary tree.
     * 
     * NOTE: You may assume that duplicates do not exist in the tree.
     * 
     * sol:
     * 1. Root of the tree is start of preOrder, find the root index in inorder
     * 2. Left sub tree will be left to the inorder root idx, accordingly find the
     * range in preorder and assign this as left subtree to root
     * 3. Right sub tree will be right to the inorder root idx, accordingly find the
     * range in preorder and assign this as right subtree to root
     * 
     * T.C: O(N^2), S.C: O(H), logN <= H <= N
     */
    public TreeNode btFromInorderAndPreorder(int[] inorder, int[] preorder) {
        return btFromInorderAndPreorderUtil(inorder, preorder, 0, inorder.length - 1, 0, preorder.length - 1);
    }

    private TreeNode btFromInorderAndPreorderUtil(int[] inorder, int[] preorder, int inStart, int inEnd, int preStart,
            int preEnd) {

        if (preStart > preEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoodIdx = findRootIdx(inorder, inStart, inEnd, root.val);
        if (inRoodIdx == -1)
            return null;

        root.left = btFromInorderAndPreorderUtil(inorder, preorder, inStart, inRoodIdx - 1, preStart + 1,
                preStart + inRoodIdx - inStart);

        root.right = btFromInorderAndPreorderUtil(inorder, preorder, inRoodIdx + 1, inEnd,
                preStart + inRoodIdx - inStart + 1,
                preEnd);
        return root;
    }

}
