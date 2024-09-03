package HashSet;

import java.util.HashSet;
import java.util.Set;

// LC - 1496
// https://leetcode.com/problems/path-crossing
public class PathCrossing {
    public static boolean isPathCrossing(String path) {
        Set<String> visitedPath = new HashSet<>();
        visitedPath.add("0$0");
        int x = 0, y = 0;
        for (int i = 0; i < path.length(); i++) {
            char ch = path.charAt(i);
            if (ch == 'N')
                y++;
            else if (ch == 'E')
                x++;
            else if (ch == 'S')
                y--;
            else
                x--;
            if (!visitedPath.add(x+"$"+y)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPathCrossing("NES"));
        System.out.println(isPathCrossing("NESWW"));
    }
}
