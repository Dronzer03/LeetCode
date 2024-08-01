package Trees;

// Floor in BST - Coding Ninjas
// https://www.codingninjas.com/studio/problems/floor-from-bst_920457

// GFG
// https://www.geeksforgeeks.org/problems/floor-in-bst/1
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

    public static int floor(TreeNode root, int x) {
        // Code here
        if (root == null)
            return -1;

        if (x == root.val)
            return x;
        if (x < root.val) {
            return floor(root.left, x);
        }
        else {
            int right = floor(root.right, x);
            if (right == -1 && root.val < x)
                return root.val;
            return right;
        }
    }
}
