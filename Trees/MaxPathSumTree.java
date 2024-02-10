package Trees;

// LC - 124
// https://leetcode.com/problems/binary-tree-maximum-path-sum
public class MaxPathSumTree {
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;

        findMaxPathSum(root);

        return max;
    }

    private int findMaxPathSum(TreeNode root) {
        if (root == null)
            return 0;

        int left = Math.max(findMaxPathSum(root.left), 0);
        int right = Math.max(findMaxPathSum(root.right), 0);

        max = Math.max(left + right + root.val, max);

        return root.val + Math.max(left, right);
    }
}
