package Trees;

import java.util.ArrayList;
import java.util.List;

// LC - 257
// https://leetcode.com/problems/binary-tree-paths
// https://www.geeksforgeeks.org/problems/root-to-leaf-paths/1
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

    public static ArrayList<ArrayList<Integer>> Paths(TreeNode root) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        dfs(root, result, current);
        return result;
    }

    private static void dfs(TreeNode root, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> current) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            current.add(root.val);
            result.add(new ArrayList<>(current));
            current.remove(current.size() - 1);
            return;
        }

        current.add(root.val);
        dfs(root.left, result, current);
        dfs(root.right, result, current);
        current.remove(current.size() - 1);
    }

}
