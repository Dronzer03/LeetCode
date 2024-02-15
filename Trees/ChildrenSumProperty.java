package Trees;

// Coding Ninjas
// https://www.codingninjas.com/studio/problems/childrensumproperty_790723
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
}
