package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Coding Ninjas
// https://www.codingninjas.com/studio/problems/left-view-of-binary-tree_625707
public class LeftViewOfTree {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        rightView(root, map, 0);
        for (int i=0; i<map.size(); i++)
            result.add(map.get(i));
        return result;
    }

    private void rightView(TreeNode root, Map<Integer, Integer> map, int y) {
        if (root == null)
            return;

        rightView(root.right, map, y + 1);
        map.put(y, root.val);
        rightView(root.left, map, y + 1);
    }
}
