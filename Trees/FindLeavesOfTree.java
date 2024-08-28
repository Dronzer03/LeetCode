package Trees;

import java.util.ArrayList;
import java.util.List;

// LC - 366
// https://leetcode.com/problems/find-leaves-of-binary-tree
public class FindLeavesOfTree {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root) {
        if (root == null)
            return -1;

        int leftLevel = dfs(root.left);
        int rightLevel = dfs(root.right);

        int currentLevel = Math.max(leftLevel, rightLevel) + 1;

        while (ans.size() <= currentLevel) {
            ans.add(new ArrayList<>());
        }

        ans.get(currentLevel).add(root.val);
        return currentLevel;
    }
}
