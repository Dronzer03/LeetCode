package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// LC - 1239
// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-character
public class ConcatStringWithUniqueCharacters {
    public static int maxLength(List<String> arr) {
        int[] freq = new int[26];
        return checkMaxLen(arr, 0, freq);
    }

    private static int checkMaxLen(List<String> arr, int index, int[] freq) {
        if (index == arr.size()) {
            return 0;
        }
        int take = 0;
        int[] temp = Arrays.copyOf(freq, freq.length);
        temp = checkIsValid(arr.get(index), temp);
        if (temp != null) {
            take = arr.get(index).length() + checkMaxLen(arr, index + 1, temp);
        }
        int notTake = checkMaxLen(arr, index + 1, freq);
        return Math.max(take, notTake);
    }

    private static int[] checkIsValid(String s, int[] freq) {
        for (int i=0; i<s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1)
                return null;
            freq[s.charAt(i) - 'a']++;
        }
        return freq;
    }

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("un");
        arr.add("iq");
        arr.add("que");
        System.out.println(maxLength(arr));
    }
}
