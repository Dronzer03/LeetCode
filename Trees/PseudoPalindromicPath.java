package Trees;

// LC - 1457
// https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree
public class PseudoPalindromicPath {
    public static int pseudoPalindromicPaths (TreeNode root) {
        int[] map = new int[10];
        return count(root, map, 0);
    }

    private static int count(TreeNode root, int[] map, int oddCount) {
        if (root.left == null && root.right == null) {
            map[root.val]++;
            if (map[root.val] % 2 == 1)
                oddCount++;
            else
                oddCount--;
            int result = oddCount <= 1 ? 1 : 0;
            map[root.val]--;
            return result;
        }

        int total = 0;
        map[root.val]++;
        if (map[root.val] % 2 == 0)
            oddCount--;
        else
            oddCount++;
        if (root.left != null) {
            total += count(root.left, map, oddCount);
        }

        if (root.right != null) {
            total += count(root.right, map, oddCount);
        }

        map[root.val]--;
        return total;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(1));
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3, null, new TreeNode(1));
        root.right.right = new TreeNode(1);
        System.out.println(pseudoPalindromicPaths(root));
    }
}
