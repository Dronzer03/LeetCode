package Strings;

// LC - 151
// https://leetcode.com/problems/reverse-words-in-a-string
public class ReverseWords {
    public String reverseWords(String s) {
        String[] strArray = s.split("\\s+");

        StringBuilder str = new StringBuilder();

        for (int index = strArray.length - 1; index >= 0 ; index--) {
            str.append(strArray[index]);
            str.append(" ");
        }
        return str.toString().trim();
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
