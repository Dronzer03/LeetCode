package TwoPointers;

import java.util.Arrays;

// LC - 455
// https://leetcode.com/problems/assign-cookies
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i=0, j=0;
        int contentChildren = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                contentChildren++;
                i++;
                j++;
            } else {
                break;
            }
        }

        return contentChildren;
    }
}
