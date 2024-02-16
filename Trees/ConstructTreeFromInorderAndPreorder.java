package Trees;

import java.util.HashMap;
import java.util.Map;

// LC - 105
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
public class ConstructTreeFromInorderAndPreorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int index = 0; index < inorder.length; index++) {
            inorderMap.put(inorder[index], index);
        }

        return buildUniqueTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length, inorderMap);
    }

    private TreeNode buildUniqueTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inorderMap) {
        if (preStart > preEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inorderMap.get(root.val);
        int numsOnLeft = inRoot - inStart;

        root.left = buildUniqueTree(preorder, preStart + 1, preStart + numsOnLeft, inorder, inStart, inRoot - 1, inorderMap);
        root.right = buildUniqueTree(preorder, preStart + numsOnLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inorderMap);

        return root;
    }
}
