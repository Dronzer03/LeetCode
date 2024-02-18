package Trees;

public class InorderSuccessorBST {
    TreeNode successor = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode x) {
        if (root == null)
            return null;
        findSuccessor(root, x);
        return successor;
    }

    private void findSuccessor(TreeNode root, TreeNode x) {
        if (root == null)
            return;

        if (root.val > x.val) {
            successor = root;
            findSuccessor(root.left, x);
        } else {
            findSuccessor(root.right, x);
        }
    }
}
