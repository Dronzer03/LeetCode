package Strings;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1)
            return strs[0];

        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];

        int index = 0;

        while (index < first.length() && index < last.length()) {
            if (first.charAt(index) != last.charAt(index))
                break;
            index++;
        }

        return first.substring(0, index);
    }
}
