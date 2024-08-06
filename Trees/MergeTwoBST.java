package Trees;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoBST {
    public static TreeNode mergeBST(TreeNode root1, TreeNode root2) {
        // Write your code here.
        List<Integer> tree1 = new ArrayList<>();
        List<Integer> tree2 = new ArrayList<>();
        inorder(root1, tree1);
        inorder(root2, tree2);
        List<Integer> mergedList = mergeTwoLists(tree1, tree2);
        return createTreeFromInorder(mergedList, 0, mergedList.size() - 1);
    }

    private static TreeNode createTreeFromInorder(List<Integer> mergedList, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end)/2;
        TreeNode root = new TreeNode(mergedList.get(mid));
        root.left = createTreeFromInorder(mergedList, start, mid - 1);
        root.right = createTreeFromInorder(mergedList, mid + 1, end);
        return root;
    }

    private static List<Integer> mergeTwoLists(List<Integer> tree1, List<Integer> tree2) {
        List<Integer> mergedList = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        while (index1 < tree1.size() && index2 < tree2.size()) {
            mergedList.add(tree1.get(index1) <= tree2.get(index2) ? tree1.get(index1++) : tree2.get(index2++));
        }
        while (index1 < tree1.size())
            mergedList.add(tree1.get(index1++));
        while (index2 < tree2.size())
            mergedList.add(tree2.get(index2++));
        return mergedList;
    }

    private static void inorder(TreeNode root, List<Integer> tree) {
        if (root == null)
            return;

        inorder(root.left, tree);
        tree.add(root.val);
        inorder(root.right, tree);
    }
}
