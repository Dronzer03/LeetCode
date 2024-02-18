package Trees;

// LC - 99
// https://leetcode.com/problems/recover-binary-search-tree
public class RecoverBST {
    TreeNode first = null;
    TreeNode prev = null;
    TreeNode last = null;
    public void recoverTree(TreeNode root) {
        if (root == null)
            return;

        traverseInorder(root);
        int temp = last.val;
        last.val = first.val;
        first.val = temp;
    }

    private void traverseInorder(TreeNode root) {
        if (root == null)
            return;

        traverseInorder(root.left);
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
            }
            last = root;
        }
        prev = root;
        traverseInorder(root.right);
    }
}
