package Trees;

public class CeilInBST {
    int ceil = Integer.MAX_VALUE;
    public int findCeil(TreeNode node, int x) {
        traverse(node, x);
        return ceil;
    }

    public void traverse(TreeNode node, int x) {
        if (node == null)
            return;

        if (node.val >= x)
            ceil = Math.min(ceil, node.val);

        if (node.val == x)
            return;

        if (x > node.val)
            traverse(node.right, x);
        traverse(node.left, x);
    }

    public int findCeilIterative(TreeNode root, int x) {
        int ceilVal = Integer.MAX_VALUE;
        while (root != null) {
            if (root.val == x) {
                return root.val;
            }

            if (root.val > x) {
                ceilVal = Math.min(ceilVal, root.val);
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return ceilVal;
    }
}
