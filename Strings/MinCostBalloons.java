package Strings;


// LC - 1578
// https://leetcode.com/problems/minimum-time-to-make-rope-colorful
public class MinCostBalloons {
    public static int minCost(String colors, int[] neededTime) {
        int minTime = 0;
        for (int i = 0; i < colors.length(); i++) {
            char ch = colors.charAt(i);
            int requiredTime = neededTime[i];
            while (i + 1 < colors.length() && colors.charAt(i + 1) == ch) {
                if (requiredTime > neededTime[i + 1]) {
                    minTime += neededTime[i + 1];
                } else {
                    minTime += requiredTime;
                    requiredTime = neededTime[i + 1];
                }
                i++;
            }
        }
        return minTime;
    }

    public static int minCostOtherWay(String colors, int[] neededTime) {
        int minTime = 0;
        int maxTime = neededTime[0];
        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                if (maxTime > neededTime[i]) {
                    minTime += neededTime[i];
                } else {
                    minTime += maxTime;
                    maxTime = neededTime[i];
                }
            } else {
                maxTime = neededTime[i];
            }
        }
        return minTime;
    }

    public static void main(String[] args) {
        String colors = "aaabbbabbbb";
        int[] neededTime = {3, 5, 10, 7, 5, 3, 5, 5, 4, 8, 1};
        System.out.println(minCost(colors, neededTime));
        System.out.println(minCostOtherWay(colors, neededTime));
    }
}
