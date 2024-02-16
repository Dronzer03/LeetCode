package Trees;

import java.util.HashMap;
import java.util.Map;

// LC - 106
// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
public class ConstructTreeFromInorderAndPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int index = 0; index < inorder.length; index++) {
            inorderMap.put(inorder[index], index);
        }

        return buildUniqueTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inorderMap);
    }

    private TreeNode buildUniqueTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> inorderMap) {
        if (inStart > inEnd || postStart > postEnd)
            return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = inorderMap.get(root.val);
        int numsOnLeft = index - inStart;

        root.left = buildUniqueTree(inorder, inStart, index - 1, postorder, postStart, postStart + numsOnLeft - 1, inorderMap);
        root.right = buildUniqueTree(inorder, index + 1, inEnd, postorder, postStart + numsOnLeft, postEnd - 1, inorderMap);

        return root;
    }
}
