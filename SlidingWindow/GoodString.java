package SlidingWindow;

public class GoodString {
    public String makeGood(String s) {
        int n = s.length();

        for (int i = 0; i < n - 1; i++) {
            if (Math.abs(s.charAt(i) - s.charAt(i+1)) == 32) {
                return makeGood(s.substring(0, i) + s.substring(i+2));
            }
        }

        return s;
    }

    public static void main(String[] args) {
        System.out.println(new GoodString().makeGood("leEeetcode"));
    }
}
