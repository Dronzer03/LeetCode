package Trees;

// LC - 236
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root;

        if (left == null)
            return right;
        return left;
    }

    int count = 0;
    public TreeNode lca2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (root == p || root == q) {
            count++;
            return root;
        }

        if (left != null && right != null)
            return root;

        if (left == null)
            return right;
        return left;
    }

    public TreeNode lca3(TreeNode p, TreeNode q) {
        TreeNode a = p, b = q;
        while (a != b) {
            a = a.parent == null ? q : a.parent;
            b = b.parent == null ? p : b.parent;
        }
        return a;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
    }
}
