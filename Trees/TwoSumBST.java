package Trees;

import java.util.Stack;

// LC - 653
// https://leetcode.com/problems/two-sum-iv-input-is-a-bst
public class TwoSumBST {
    Stack<TreeNode> next = new Stack<>();
    Stack<TreeNode> prev = new Stack<>();
    public boolean findTarget(TreeNode root, int k) {
        initNext(root);
        initPrev(root);
        int sum = -1;
        int nextVal = nextNode();
        int prevVal = prevNode();

        while (!next.isEmpty() && !prev.isEmpty()) {
            if (nextVal + prevVal == k) {
                if (nextVal == prevVal)
                    return false;
                return true;
            }
            if (nextVal + prevVal < k)
                nextVal = nextNode();
            else
                prevVal = prevNode();
        }

        return false;
    }

    private int prevNode() {
        TreeNode prevNode = prev.pop();
        TreeNode node = prevNode.left;
        while (node != null) {
            prev.push(node);
            node = node.right;
        }
        return prevNode.val;
    }

    public int nextNode() {
        TreeNode nextNode = next.pop();
        TreeNode node = nextNode.right;
        while (node != null) {
            next.push(node);
            node = node.left;
        }
        return nextNode.val;
    }

    private void initNext(TreeNode root) {
        while (root != null) {
            next.push(root);
            root = root.left;
        }
    }

    private void initPrev(TreeNode root) {
        while (root != null) {
            prev.push(root);
            root = root.right;
        }
    }
}
