package Trees;

import java.util.HashMap;
import java.util.Map;

// LC - 2196
// https://leetcode.com/problems/create-binary-tree-from-descriptions
public class TreeFromDescription {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        for (int[] current : descriptions) {
            TreeNode curr = nodeMap.containsKey(current[0]) ? nodeMap.get(current[0]) : new TreeNode(current[0]);
            TreeNode child = nodeMap.containsKey(current[1]) ? nodeMap.get(current[1]) : new TreeNode(current[1]);

            if (current[2] == 1)
                curr.left = child;
            else
                curr.right = child;

            parentMap.put(child, curr);
            nodeMap.put(current[1], child);
            nodeMap.put(current[0], curr);
        }

        for (TreeNode node : nodeMap.values()) {
            if (!parentMap.containsKey(node))
                return node;
        }

        return null;
    }

    public static void main(String[] args) {
        int[][] desc = {{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}};
        new TreeFromDescription().createBinaryTree(desc);
    }
}
