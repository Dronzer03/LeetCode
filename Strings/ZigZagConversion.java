package Strings;

import java.util.Arrays;

// LC - 6
// https://leetcode.com/problems/zigzag-conversion
public class ZigZagConversion {
    // input - s = "PAYPALISHIRING"
    // output - "PINALSIGYAHRPI"
    //P     I    N
    //A   L S  I G
    //Y A   H R
    //P     I

    public static String convert(String s, int numRows) {
        if (s.length() <= 1 || numRows == 1)
            return s;
        char[][] res = new char[numRows][s.length()];
        int i = 0, j = 0;
        boolean increment = true;
        for (char c : s.toCharArray()) {
            res[i][j] = c;
            if (increment && i == numRows - 1) {
                increment = false;
                i--;
                j++;
            } else if (!increment && i == 0) {
                i++;
                increment = true;
            } else if (increment) {
                i++;
            } else if (!increment) {
                j++;
                i--;
            }
        }
        System.out.println(Arrays.deepToString(res));
        String resString = "";
        for (i = 0; i < numRows; i++) {
            for (j = 0; j < s.length(); j++) {
                if (res[i][j] != 0) {
                    resString += res[i][j];
                }
            }
        }
        System.out.println(resString);
        return resString;
    }

    public static String convertSmart(String s, int numRows) {
        if (s.length() <= 1 || numRows == 1)
            return s;
        String res = "";
        for (int i = 0; i < numRows; i++) {
            int increment = (numRows - 1) * 2;
            for (int j = i; j < s.length(); j = j + increment) {
                res += s.charAt(j);
                if (i > 0 && i < numRows - 1 && (j + increment - (2 * i) < s.length())) {
                    res += s.charAt(j + increment - (2 * i));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        s = convert(s, 4);
    }
}
