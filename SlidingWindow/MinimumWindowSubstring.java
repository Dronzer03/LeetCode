package SlidingWindow;

// LC - 76
// https://leetcode.com/problems/minimum-window-substring
public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";

        int left = 0;
        int right = 0;
        String minSubstring = new String(s + "Test");

        int[] tMap = new int[123];
        for (Character c : t.toCharArray())
            tMap[c]++;

        int[] sMap = new int[123];

        // ADOBECODEBANC
        while (left < s.length() && right < s.length()) {
            char charAtRight = s.charAt(right);
            if (tMap[charAtRight] > 0) {
                sMap[charAtRight]++;
            }

            if (checkStrings(sMap, tMap)) {
                while (left < s.length() && checkValidString(sMap, tMap, s.charAt(left)))
                    left++;
                String currString = s.substring(left, right + 1);
                if (currString.length() < minSubstring.length())
                    minSubstring = currString;

                if (left < s.length()) {
                    sMap[s.charAt(left)]--;
                    left++;
                }
            }

            right++;
        }

        return minSubstring.equals(s + "Test") ? "" : minSubstring;
    }

    private static boolean checkValidString(int[] sMap, int[] tMap, char c) {
        if (tMap[c] > 0) {
            sMap[c]--;
            if (checkStrings(sMap, tMap))
                return true;
            else {
                sMap[c]++;
                return false;
            }
        }
        return true;
    }

    private static boolean checkStrings(int[] sMap, int[] tMap) {
        for (int i = 0; i < 123; i++) {
            if (sMap[i] < tMap[i])
                return false;
        }

        return true;
    }

    public String minWindowOptimal(String s, String t) {
        if (t.isEmpty())
            return "";

        int left = 0;
        int right = 0;
        int needed = 0;

        int[] required = new int[128];
        int[] current = new int[128];
        for (char c : t.toCharArray()) {
            required[c]++;
            if (required[c] == 1)
                needed++;
        }


        int have = 0;
        int minLen = s.length() + 1;
        String result = "";

        while (left < s.length() && right < s.length()) {
            char c = s.charAt(right);
            if (required[c] > 0) {
                current[c]++;
                if (current[c] == required[c]) {
                    have++;
                }
            }
            while (have == needed && left <= right) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    result = s.substring(left, right + 1);
                }
                char leftChar = s.charAt(left);
                if (required[leftChar] > 0) {
                    current[leftChar]--;
                    if (current[leftChar] < required[leftChar]) {
                        have--;
                    }
                }
                left++;
            }
            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "aa";
        String t = "aa";
        System.out.println(minWindow(s, t));
        System.out.println(new MinimumWindowSubstring().minWindowOptimal(s, t));
    }
}
