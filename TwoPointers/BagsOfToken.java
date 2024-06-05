package TwoPointers;

import java.util.Arrays;

public class BagsOfToken {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0;
        Arrays.sort(tokens);

        int left = 0;
        int right = tokens.length - 1;
        int maxScore = 0;

        while (left <= right) {
            if (tokens[left] <= power) {
                score++;
                maxScore = Math.max(maxScore, score);
                power -= tokens[left];
                left++;
            } else if (score >  0) {
                power += tokens[right];
                score--;
                right--;
            } else {
                return maxScore;
            }
        }

        return maxScore;
    }

    public static void main(String[] args) {
        int[] tokens = {100};
        System.out.println(new BagsOfToken().bagOfTokensScore(tokens, 50));
    }
}
