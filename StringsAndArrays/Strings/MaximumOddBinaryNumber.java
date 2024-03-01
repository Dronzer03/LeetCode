package StringsAndArrays.Strings;

// LC - 2864
// https://leetcode.com/problems/maximum-odd-binary-number
public class MaximumOddBinaryNumber {
    public String maximumOddBinaryNumber(String s) {
        int ones = 0;
        for (char ch : s.toCharArray())
            if (ch == '1')
                ones++;

        ones--;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length()-1; i++) {
            if (ones > 0) {
                sb.append('1');
                ones--;
            } else {
                sb.append('0');
            }
        }
        sb.append('1');
        return sb.toString();
    }
}
