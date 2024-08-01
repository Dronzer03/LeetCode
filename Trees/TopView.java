package Trees;

import java.util.*;

// Coding Ninjas - LC Premium
// https://www.codingninjas.com/studio/problems/top-view-of-binary-tree_799401

// GFG
// https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
public class TopView {
    static class TreePair {
        TreeNode node;
        int xAxis;
        TreePair(TreeNode node, int xAxis) {
            this.node = node;
            this.xAxis = xAxis;
        }
    }
    public static ArrayList<Integer> topView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList();
        if (root == null)
            return result;
        Queue<TreePair> queue = new LinkedList<>();
        queue.offer(new TreePair(root, 0));

        Map<Integer, Integer> map = new TreeMap<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreePair treePair = queue.poll();
                TreeNode node = treePair.node;
                int xAxis = treePair.xAxis;
                if (node.left != null) {
                    queue.offer(new TreePair(node.left, xAxis - 1));
                }
                if (node.right != null) {
                    queue.offer(new TreePair(node.right, xAxis + 1));
                }
                if (!map.containsKey(xAxis)) {
                    map.put(xAxis, node.val);
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }

    static ArrayList<Integer> topViewDFS(TreeNode root) {
        TreeMap<Integer, int[]> map = new TreeMap<>();
        dfs(root, map, 0, 0);
        ArrayList<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            res.add(entry.getValue()[1]);
        }
        return res;
    }

    static void dfs(TreeNode root, TreeMap<Integer, int[]> map, int x, int y) {
        int[] curr;
        if (map.containsKey(x)) {
            curr = map.get(x);
            if (y < curr[1]) {
                curr[0] = root.val;
                curr[1] = y;
                map.put(x, curr);
            }
        } else {
            curr = new int[2];
            curr[0] = root.val;
            curr[1] = y;
            map.put(x, curr);
        }

        dfs(root.left, map, x - 1, y + 1);
        dfs(root.right, map, x + 1, y + 1);
    }
}
