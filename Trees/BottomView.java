package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// Coding Ninjas & GFG
// https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
// https://www.codingninjas.com/studio/problems/bottom-view-of-binary-tree_893110
public class BottomView {
    public static List<Integer> bottomView(TreeNode root) {
        // Write your code here.
        List<Integer> result = new ArrayList<>();
        Map<Integer, int[]> map = new TreeMap<>();
        traverse(root, map, 0, 0);
        for (Map.Entry<Integer, int[]> entry : map.entrySet())
            result.add(entry.getValue()[1]);
        return result;
    }

    public static void traverse(TreeNode root, Map<Integer, int[]> map, int xAxis, int yAxis) {
        if (root == null)
            return;

        traverse(root.left,map, xAxis - 1, yAxis + 1);
        int[] temp;
        if (map.containsKey(xAxis)) {
            temp = map.get(xAxis);
            if (yAxis >= temp[0]) {
                temp[0] = yAxis;
                temp[1] = root.val;
            }
        } else {
            temp = new int[2];
            temp[0] = yAxis;
            temp[1] = root.val;
        }
        map.put(xAxis, temp);
        traverse(root.right,map, xAxis + 1, yAxis + 1);
    }
}
