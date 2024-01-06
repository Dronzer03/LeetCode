package DynamicProgramming;

import java.util.*;

public class MaxProfitInJobScehduling {

    public Map<String, Integer> dp;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];

        for (int i=0; i<startTime.length; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        });
        dp = new HashMap<>();
        return maxProfit(jobs, -1, 0);
    }

    private int maxProfit(int[][] jobs, int lastIndex, int index) {
        if (index == jobs.length)
            return 0;

        String key = index + "_" + lastIndex;

        if (dp.get(key) != null)
            return dp.get(key);

        //take case
        int result = 0;
        if (lastIndex == -1 || jobs[lastIndex][1] <= jobs[index][0]) {
            result = jobs[index][2] + maxProfit(jobs, index, index + 1);
        }

        dp.put(key, Math.max(result, maxProfit(jobs, lastIndex, index + 1)));

        return dp.get(key);
    }

    public static void main(String[] args) {
        int[] startTime = {6,15,7,11,1,3,16,2};
        int[] endTime = {19,18,19,16,10,8,19,8};
        int[] profit = {2,9,1,19,5,7,3,19};

        int[] startTime1 = {1, 2, 3, 4, 6};
        int[] endTime1 = {3, 5, 10, 6, 9};
        int[] profit1 = {20, 20, 100, 70, 60};

        MaxProfitInJobScehduling max = new MaxProfitInJobScehduling();

        System.out.println(max.jobScheduling(startTime, endTime, profit));
        System.out.println(max.jobScheduling(startTime1, endTime1, profit1));
    }
}
