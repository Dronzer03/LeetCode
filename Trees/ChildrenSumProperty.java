package Trees;

// Coding Ninjas
// https://www.codingninjas.com/studio/problems/childrensumproperty_790723

// GFG
// https://www.geeksforgeeks.org/problems/children-sum-parent/1
public class ChildrenSumProperty {
    public static void changeTree(TreeNode root) {
        if (root == null)
            return;

        traverse(root, 0);
    }

    public static int traverse(TreeNode root, int val) {
        if (root == null)
            return 0;

        if (root.val < val) {
            root.val = val;
        }

        if (root.left == null && root.right == null)
            return root.val;

        int left = traverse(root.left, root.val);
        int right = traverse(root.right, root.val);
        return root.val = left + right;
    }

    // GFG
    public static int isSumProperty(TreeNode root) {
        if (root == null)
            return 1;

        int left = root.left == null ? 0 : root.left.val;
        int right = root.right == null ? 0 : root.right.val;

        if (root.val != (left + right))
            return 0;

        if (root.left != null && isSumProperty(root.left) == 0)
            return 0;

        if (root.right != null && isSumProperty(root.right) == 0)
            return 0;

        return 1;
    }
}
