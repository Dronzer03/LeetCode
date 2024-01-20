package DynamicProgramming;

import java.util.*;

// LC - 312
// https://leetcode.com/problems/burst-balloons/
public class BurstBalloons {
    public static int maxCoins(int[] nums) {
        List<Integer> balloons = Arrays.stream(nums).boxed().toList();
        Map<List<Integer>, Integer> dp = new HashMap<>();
        return maxValue(balloons, dp);
    }

    private static int maxValue(List<Integer> balloons, Map<List<Integer>, Integer> dp) {
        if (balloons.size() == 1)
            return balloons.get(0);

        if (dp.containsKey(balloons))
            return dp.get(balloons);

        int max = 0;
        for (int index = 0; index < balloons.size(); index++) {
            int coins = balloons.get(index);
            if (index - 1 >= 0)
                coins *= balloons.get(index - 1);
            if (index + 1 < balloons.size())
                coins *= balloons.get(index + 1);
            List<Integer> burst = new ArrayList<>(balloons);
            burst.remove(index);
            coins = coins + maxValue(burst, dp);
            max = Math.max(coins, max);
        }
        dp.put(balloons, max);
        return max;
    }

    //Better way
    public static int maxCoinTabulated(int[] balloons) {
        int n = balloons.length;
        List<Integer> cost = new ArrayList<>(Arrays.stream(balloons).boxed().toList());
        cost.add(1);
        cost.add(0, 1);
        Integer[][] dp = new Integer[balloons.length+1][balloons.length+1];
        return costOfBalloons(cost, 1, n, dp);
    }

    private static int costOfBalloons(List<Integer> balloons, int i, int j, Integer[][] dp) {
        if (i > j)
            return 0;

        if (dp[i][j] != null)
            return dp[i][j];

        int max = Integer.MIN_VALUE;

        for (int index = i; index <= j; index ++) {
            int cost = balloons.get(i - 1) * balloons.get(index) * balloons.get(j + 1)
                    + costOfBalloons(balloons, i, index - 1, dp)
                    + costOfBalloons(balloons, index + 1, j, dp);
            max = Math.max(cost, max);
        }

        return dp[i][j] = max;
    }

    public static void main(String[] args) {
        int[] balloons = {8,3,4,3,5,0,5,6,6,2,8,5,6,2,3,8,3,5,1,0,2};
//        System.out.println(maxCoins(balloons));
        System.out.println(maxCoinTabulated(balloons));
    }
}
