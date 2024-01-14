package DynamicProgramming;

// LC - 1335
// https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule
public class MinDifficultyJobScheduling {
    public static void main(String[] args) {
        int[] jobDifficulty = {9, 9, 9};
        int d = 3;
        System.out.println(minDifficulty(jobDifficulty, d));
    }

    public static int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d)
            return -1;

        return findMinDifficulty(jobDifficulty, d, 0, 0);
    }

    private static int findMinDifficulty(int[] jobDifficulty, int d, int index, int maxDifficulty) {
        if (index == jobDifficulty.length) {
            if (d != 0)
                return 600000;
            else
                return maxDifficulty;
        }

        if (d < 0)
            return 600000;


        //Make Partition
        maxDifficulty = Math.max(maxDifficulty, jobDifficulty[index]);
        int takeResult = maxDifficulty + findMinDifficulty(jobDifficulty, d - 1, index + 1, 0);

        //Don't Make Partition and proceed
        int notTakeResult = findMinDifficulty(jobDifficulty, d, index + 1, maxDifficulty);

        return Math.min(takeResult, notTakeResult);
    }

    public static int minDifficultyDp(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d)
            return -1;

        Integer[][][] dp = new Integer[d + 1][jobDifficulty.length + 1][1001];

        return findMinDifficultyDp(jobDifficulty, d, 0, 0, dp);
    }

    private static int findMinDifficultyDp(int[] jobDifficulty, int d, int index, int maxDifficulty, Integer[][][] dp) {
        if (index == jobDifficulty.length) {
            if (d != 0)
                return 600000;
            else
                return maxDifficulty;
        }

        if (d < 0)
            return 600000;

        if (dp[d][index][maxDifficulty] != null)
            return dp[d][index][maxDifficulty];


        //Make Partition
        maxDifficulty = Math.max(maxDifficulty, jobDifficulty[index]);
        int takeResult = maxDifficulty + findMinDifficultyDp(jobDifficulty, d - 1, index + 1, 0, dp);

        //Don't Make Partition and proceed
        int notTakeResult = findMinDifficultyDp(jobDifficulty, d, index + 1, maxDifficulty, dp);

        return dp[d][index][maxDifficulty] = Math.min(takeResult, notTakeResult);
    }
}
