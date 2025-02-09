package Trees;

public class ClosestBSTValue {
    public int closestValue(TreeNode root, double target) {
        int ans = root.val;
        double diff = Double.MAX_VALUE;

        while (root != null) {
            double d = Math.abs(root.val - target);
            if (d < diff || (d == diff && root.val < ans)) {
                ans = root.val;
                diff = d;
            }
            if (root.val > target) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return ans;
    }
}
