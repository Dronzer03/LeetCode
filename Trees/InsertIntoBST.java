package Trees;

// LC - 701
// https://leetcode.com/problems/insert-into-a-binary-search-tree
public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = root;
        TreeNode nodeToInsert = new TreeNode(val);
        while (node != null) {
            if (val > node.val) {
                if (node.right == null) {
                    node.right = nodeToInsert;
                    return root;
                } else {
                    node = node.right;
                }
            } else {
                if (node.left == null) {
                    node.left = nodeToInsert;
                    return root;
                } else {
                    node = node.left;
                }
            }
        }
        return nodeToInsert;
    }
}
