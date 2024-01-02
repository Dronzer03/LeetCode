package DynamicProgramming;

public class NinjaTraining {
    public static int maximumPoints(int[][] points, int n) {
        Integer[][] dp = new Integer[n][3];
        return maxTrain(points, -1, 0, dp);
    }

    private static int maxTrain(int[][] points, int lastTrained, int index, Integer[][] dp) {
        if (index == points.length)
            return 0;

        if (lastTrained != -1 && dp[index][lastTrained] != null)
            return dp[index][lastTrained];

        int res = 0;
        for (int i = 0; i <= 2; i++) {
            if (lastTrained != i) {
                res = Math.max(res, points[index][i] + maxTrain(points, i, index + 1, dp));
            }
        }

        if (lastTrained != -1)
            dp[index][lastTrained] = res;
        return res;
    }

    // Difficult to understand
    public static int maxPointsDp(int[][] points, int n) {
        int[][] dp = new int[n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][1], points[0][0]);
        dp[0][3] = Math.max(points[0][0], dp[0][0]);

        // For all days
        for (int day=1; day<points.length; day++) {
            // for all last
            for (int last=0; last <= 3; last++) {
                dp[day][last] = 0;
                for (int i=0; i<3; i++) {
                    if (i != last) {
                        dp[day][last] = Math.max(dp[day][last], points[day][i] + dp[day-1][i]);
                    }
                }
            }
        }

        return dp[n-1][3];
    }

    public static void main(String[] args) {
        int[][] points = {{18, 11, 19}, {4, 13, 7}, {1, 8, 13}};
        System.out.println(maximumPoints(points, 3));
        System.out.println(maxPointsDp(points, 3));
    }
}
