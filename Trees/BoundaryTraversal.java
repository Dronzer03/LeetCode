package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Coding Ninjas - LC Premium
// https://www.codingninjas.com/studio/problems/boundary-traversal-of-binary-tree_790725
public class BoundaryTraversal {
    public static List<Integer> traverseBoundary(TreeNode root) {
        // Write your code here.
        if (root == null)
            return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        addLeftBoundary(root, result);
        addLeafNodes(root, result);
        addRightNodes(root, result);
        return result;
    }

    private static void addRightNodes(TreeNode root, List<Integer> result) {
        TreeNode curr = root.right;
        Stack<Integer> stack = new Stack<>();
        while (curr != null) {
            if (curr.left != null && curr.right != null)
                stack.add(curr.val);
            if (curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }
        while (!stack.isEmpty())
            result.add(stack.pop());
    }

    private static void addLeafNodes(TreeNode root, List<Integer> result) {
        if (root.left != null)
            addLeafNodes(root.left, result);
        if (root.left == null && root.right == null)
            result.add(root.val);
        if (root.right != null)
            addLeafNodes(root.right, result);
    }

    private static void addLeftBoundary(TreeNode root, List<Integer> result) {
        TreeNode curr = root.left;
        while (curr != null) {
            if (curr.left != null && curr.right != null)
                result.add(curr.val);
            if (curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }
}
