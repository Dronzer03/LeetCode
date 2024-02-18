package Trees;

// LC - 230
// https://leetcode.com/problems/kth-smallest-element-in-a-bst
public class KthSmallestInBST {
    int kSmall = 0;
    public int kthSmallest(TreeNode root, int k) {
        kSmall = k;
        return findKthSmallest(root);
    }

    private int findKthSmallest(TreeNode root) {
        if (root == null)
            return -1;

        int left = findKthSmallest(root.left);
        if (left != -1)
            return left;

        if (--kSmall == 0)
            return root.val;

        return findKthSmallest(root.right);
    }
}
