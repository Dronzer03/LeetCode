package Trees;

import java.util.ArrayList;
import java.util.List;

// LC - 872
// https://leetcode.com/problems/leaf-similar-trees
public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = findLeaves(root1, new ArrayList<>());
        List<Integer> leaves2 = findLeaves(root2, new ArrayList<>());
        return leaves1.equals(leaves2);
    }

    private List<Integer> findLeaves(TreeNode root, List<Integer> leaves) {
        if (root.left != null)
            findLeaves(root.left, leaves);

        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            return leaves;
        }

        if (root.right != null)
            findLeaves(root.right, leaves);

        return leaves;
    }
}
