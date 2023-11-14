package Strings;

public class ReverseWords {
    public String reverseWords(String s) {
        s = s.trim();
        String[] splittedArray = s.split("\\s+");
        String res = "";
        for (int i=splittedArray.length-1; i>=0; i--) {
            res += splittedArray[i] + " ";
        }
        res = res.trim();
        return res;
    }

    // s = "a good   example"
    // "example good a"
    public String reverseWordsAlternate(String s) {
        s = s.trim();
        String res = "";
        String temp = "";
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)==' ') {
                if (!temp.equals("")) {
                    res = temp + " " + res;
                    temp = "";
                }
            } else {
                temp += s.charAt(i);
            }
        }
        res = temp + " " + res;
        return res.trim();
    }
}
