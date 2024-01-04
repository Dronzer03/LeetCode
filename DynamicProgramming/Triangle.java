package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

// LC - 120
// https://leetcode.com/problems/triangle
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        Integer[][] dp = new Integer[triangle.size()][triangle.size()];
        return minSum (0, 0, triangle, dp);
    }

    private int minSum(int i, int j, List<List<Integer>> triangle, Integer[][] dp) {
        if (i == triangle.size() - 1)
            return triangle.get(i).get(j);

        if (dp[i][j] != null)
            return dp[i][j];

        return dp[i][j] = triangle.get(i).get(j) + Math.min(minSum(i+1, j, triangle, dp), minSum(i+1, j+1, triangle, dp));
    }

    //Tabulation
    public static int minimumTotalDp(List<List<Integer>> triangle) {
        if (triangle.size() == 1)
            return triangle.get(0).get(0);
        int[][] dp = new int[triangle.size()][triangle.size()];

        dp[0][0] = triangle.get(0).get(0);
        int minTotal = Integer.MAX_VALUE;

        for (int i=1; i<triangle.size(); i++) {
            for (int j=0; j<triangle.get(i).size(); j++) {
                dp[i][j] = triangle.get(i).get(j);
                if (j - 1 >= 0 && j < triangle.get(i-1).size())
                    dp[i][j] += Math.min(dp[i-1][j-1], dp[i-1][j]);
                else if (j - 1 >= 0)
                    dp[i][j] += dp[i-1][j-1];
                else
                    dp[i][j] += dp[i-1][j];

                if (i == triangle.size() - 1)
                    minTotal = Math.min(minTotal, dp[i][j]);
            }
        }

        return minTotal;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        list1.add(-1);
        list2.add(2);
        list2.add(3);
        list3.add(1);
        list3.add(-1);
        list3.add(-3);
        List<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);

        System.out.println(minimumTotalDp(list));
    }
}
