package TwoPointers;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        int left = s.length() - 1;
        int right = t.length() - 1;

        int skipLeft = 0;
        int skipRight = 0;
        while (left >= 0 || right >= 0) {
            if (left >= 0 && s.charAt(left) == '#') {
                skipLeft++;
                left--;
                continue;
            }
            if (skipLeft > 0) {
                skipLeft--;
                left--;
                continue;
            }
            if (right >= 0 && t.charAt(right) == '#') {
                skipRight++;
                right--;
                continue;
            }
            if (skipRight > 0) {
                skipRight--;
                right--;
                continue;
            }
            if (left < 0 || right < 0 || s.charAt(left) != t.charAt(right)) {
                return false;
            }
            left--;
            right--;
        }
        return left < 0 && right < 0;
    }

    public static void main(String[] args) {
        System.out.println(new BackspaceStringCompare().backspaceCompare("c#a#c","c"));
    }
}
