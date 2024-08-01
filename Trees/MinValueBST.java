package Trees;

// GFG
// https://www.geeksforgeeks.org/problems/minimum-element-in-bst/1
public class MinValueBST {
    int minValue(TreeNode root) {
        // code here
        if (root == null)
            return -1;

        if (root.left == null && root.right == null)
            return root.val;

        if (root.left != null)
            return minValue(root.left);
        return root.val;
    }
}
