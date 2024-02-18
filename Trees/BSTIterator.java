package Trees;

import java.util.Stack;

// LC - 123
// https://leetcode.com/problems/binary-search-tree-iterator
public class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode next = stack.pop();
        TreeNode node = next.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        return next.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void findSuccessor(TreeNode root, TreeNode x) {

    }
}
