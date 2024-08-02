package Trees;

// LC - 230
// https://leetcode.com/problems/kth-smallest-element-in-a-bst
public class KthSmallestInBST {
    int num = 0;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return -1;

        int left = kthSmallest(root.left, k);
        if (left != -1)
            return left;

        if (++num == k)
            return root.val;

        return kthSmallest(root.right, k);
    }
}
