package Strings;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        String[] words = s.split("\\s");
        return words[words.length-1].length();
    }

    public int lengthOfLastWordAnotherMethod(String s) {
        int count = 0;
        int i=s.length()-1;
        while(i>=0 && s.charAt(i)==' ')
            i--;
        for (;i>=0;i--) {
            if (s.charAt(i)==' ') {
                break;
            }
            count++;
        }
        return count;
    }
}
