package Trees;

public class FloorInBST {
    public int floorInBST(TreeNode root, int x) {
        int floor = -1;
        while (root != null) {
            if (root.val == x)
                return root.val;
            if (x < root.val) {
                root = root.left;
            } else {
                floor = root.val;
                root = root.right;
            }
        }
        return floor;
    }
}
