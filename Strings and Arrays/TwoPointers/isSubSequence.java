package TwoPointers;

public class isSubSequence {
    public static boolean isSubsequence(String s, String t) {
        int S = 0;
        int T = 0;

        while (S < s.length() && T < t.length()) {
            if (t.charAt(T) != s.charAt(S)) {
                T++;
                continue;
            }
            S++;
            T++;
        }
        if (S==s.length())
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }
}
