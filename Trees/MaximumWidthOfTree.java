package Trees;

import java.util.*;

public class MaximumWidthOfTree {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        root.val = 1;
        int curW = 0;
        int maxW = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int start = 0;
            int end = 0;
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(i == 0) start = node.val;
                if(i == size - 1) end = node.val;
                if(node.left != null){
                    node.left.val = node.val * 2;
                    q.offer(node.left);
                }
                if(node.right != null){
                    node.right.val = node.val * 2 + 1;
                    q.offer(node.right);
                }
            }
            curW = end - start + 1;
            maxW = Math.max(curW, maxW);
        }
        return maxW;
    }
}
