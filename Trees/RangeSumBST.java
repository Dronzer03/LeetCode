package Trees;

public class RangeSumBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        int res = 0;
        if (root.left != null)
            res += rangeSumBST(root.left, low, high);
        if (root.val >= low && root.val <= high)
            res += root.val;
        if (root.right != null)
            res += rangeSumBST(root.right, low, high);

        return res;
    }
}

