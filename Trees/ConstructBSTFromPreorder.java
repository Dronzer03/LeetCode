package Trees;

// LC - 1008
// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal
public class ConstructBSTFromPreorder {
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        int upperBound = Integer.MAX_VALUE;
        return constructBST(preorder, upperBound);
    }

    private TreeNode constructBST(int[] preorder, int upperBound) {
        if (index == preorder.length || preorder[index] > upperBound)
            return null;

        TreeNode root = new TreeNode(preorder[index++]);
        root.left = constructBST(preorder, root.val);
        root.right = constructBST(preorder, upperBound);
        return root;
    }
}
