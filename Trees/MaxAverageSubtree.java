package Trees;

// LC - 1120
// https://leetcode.com/problems/maximum-average-subtree
public class MaxAverageSubtree {
    double max = 0;

    public double findMaxAverage(TreeNode root) {
        dfs(root);
        return max;
    }

    private int[] dfs(TreeNode root) {
        if (root == null)
            return new int[2];

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int total = root.val + left[0] + right[0];
        int totalNodes = 1 + left[1] + right[1];

        max = Math.max(max, ((double) total / totalNodes));
        return new int[]{total, totalNodes};
    }
}
