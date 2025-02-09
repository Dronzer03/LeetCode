package Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ClosestBSTValue2 {
    int k;
    public List<Integer> closestVal2(TreeNode root, double target, int k) {
        List<Integer> queue = new LinkedList<>();
        this.k = k;
        dfs(root, target, queue);
        return queue;
    }

    private void dfs(TreeNode root, double target, List<Integer> queue) {
        if (root == null)
            return;

        dfs(root.left, target, queue);
        if (queue.size() < k) {
            queue.add(root.val);
        } else {
            if (Math.abs(queue.get(0) - target) > Math.abs(root.val - target)) {
                queue.remove(0);
                queue.add(root.val);
            } else {
                return;
            }
        }
        dfs(root.right, target, queue);
    }
}
