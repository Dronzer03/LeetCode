package Trees;

// LC - 222
// https://leetcode.com/problems/count-complete-tree-nodes
public class CountNodesInCompleteBinaryTree {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = getLeftHeight(root.left);
        int rightHeight = getRightHeight(root.right);

        if (leftHeight == rightHeight) {
            return (2 << leftHeight) - 1;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public int getLeftHeight(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }

    public int getRightHeight(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.right;
        }
        return count;
    }
}
