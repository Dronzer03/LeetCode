package Trees;

public class MaxDiffBWNodeAndAncestor {
    public int maxAncestorDiff(TreeNode root) {
        return maxDiff(root, root.val, root.val, 0);
    }

    private int maxDiff(TreeNode root, int min, int max, int maxDiff) {
        maxDiff = Math.max(maxDiff, Math.max(Math.abs(min - root.val) , Math.abs(max - root.val)));

        min = Math.min(min, root.val);
        max = Math.max(max, root.val);

        if (root.left != null)
            maxDiff = maxDiff(root.left, min, max, maxDiff);
        if (root.right != null)
            maxDiff = maxDiff(root.right, min, max, maxDiff);

        return maxDiff;
    }
}
