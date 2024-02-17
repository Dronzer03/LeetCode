package Trees;

// Floor in BST - Coding Ninjas
// https://www.codingninjas.com/studio/problems/floor-from-bst_920457
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
