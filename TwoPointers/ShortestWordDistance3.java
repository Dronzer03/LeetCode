package TwoPointers;

public class ShortestWordDistance3 {
    public int shortestDist(String[] words, String word1, String word2) {
        int ans = Integer.MAX_VALUE;
        if (word1.equals(word2)) {
            int j = -1;
            for (int index = 0; index < words.length; index++) {
                if (words[index].equals(word1)) {
                    if (j != -1) {
                        ans = Math.min(ans, index - j);
                    }
                    j = index;
                }
            }
        } else {
            int i = -1;
            int j = -1;
            for (int index = 0; index < words.length; index++) {
                if (words[index].equals(word1)) {
                    i = index;
                }
                if (words[index].equals(word2)) {
                    j = index;
                }
                if (i != -1  && j != -1) {
                    ans = Math.min(ans, Math.abs(i - j));
                }
            }
        }
        return ans;
    }
}
