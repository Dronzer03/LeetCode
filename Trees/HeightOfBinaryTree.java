package Trees;

// LC - 104
// https://leetcode.com/problems/maximum-depth-of-binary-tree
public class HeightOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        return depth(root, 0);
    }

    private int depth(TreeNode root, int height) {
        if (root == null)
            return height;

        return Math.max(depth(root.left, height+1), depth(root.right, height+1));
    }
}
