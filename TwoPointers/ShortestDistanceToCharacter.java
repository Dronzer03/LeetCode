package TwoPointers;

// LC - 821
// https://leetcode.com/problems/shortest-distance-to-a-character
public class ShortestDistanceToCharacter {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] res = new int[n];

        int prev = n;
        for (int index = 0; index < n; index++) {
            if (s.charAt(index) == c) {
                res[index] = 0;
                prev = 0;
            }
            else
                res[index] = ++prev;
        }

        prev = n;
        for (int index = n -1; index >= 0; index--) {
            if (s.charAt(index) == c) {
                res[index] = 0;
                prev = 0;
            } else {
                res[index] = Math.min(res[index], ++prev);
            }
        }

        return res;
    }
}
