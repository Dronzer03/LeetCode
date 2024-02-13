package Trees;

import java.util.ArrayList;
import java.util.List;

// LC - 257
// https://leetcode.com/problems/binary-tree-paths
public class RootToLeaf {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        return findLeaves(root, "", new ArrayList<>());
    }

    private List<String> findLeaves(TreeNode root, String s, ArrayList<String> result) {
        if (root.left == null && root.right == null) {
            s += root.val;
            result.add(s);
            return result;
        }

        if (root.left != null)
            findLeaves(root.left, s + root.val + "->", result);

        if (root.right != null)
            findLeaves(root.right, s + root.val + "->", result);

        return result;
    }
}
