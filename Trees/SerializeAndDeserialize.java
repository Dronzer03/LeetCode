package Trees;

import java.util.LinkedList;
import java.util.Queue;

// LC - 297
// https://leetcode.com/problems/serialize-and-deserialize-binary-tree
public class SerializeAndDeserialize {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder stringBuilder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    stringBuilder.append("# ");
                    continue;
                } else {
                    stringBuilder.append(node.val).append(" ");
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty())
            return null;

        String[] nodes = data.split(" ");

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for (int index = 1; index < nodes.length; index++) {
            TreeNode parent = queue.poll();
            if (!nodes[index].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[index]));
                parent.left = left;
                queue.offer(left);
            }
            if (!nodes[++index].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[index]));
                parent.right = right;
                queue.offer(right);
            }
        }

        return root;
    }
}
