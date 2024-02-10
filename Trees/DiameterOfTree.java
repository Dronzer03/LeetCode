package Trees;

// LC - 543
// https://leetcode.com/problems/diameter-of-binary-tree
public class DiameterOfTree {
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        findHeight(root);

        return max;
    }

    private int findHeight(TreeNode root) {
        if (root == null)
            return 0;

        int left = findHeight(root.left);
        int right = findHeight(root.right);

        max = Math.max(max, left + right);

        return 1 + Math.max(left, right);
    }
}
