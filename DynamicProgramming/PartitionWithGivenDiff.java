package DynamicProgramming;

import java.util.Arrays;

// GFG
// https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1
public class PartitionWithGivenDiff {

    public static int sum = 0;
    public static int diff = 0;

    public static int countPartitions(int n, int d, int[] arr) {
        sum = Arrays.stream(arr).sum();
        diff = d;
        Integer[][] dp = new Integer[n][sum + 1];
        return countPartitionsWithDiff(arr, 0, 0, dp);
    }

    private static int countPartitionsWithDiff(int[] arr, int index, int currSum, Integer[][] dp) {
        if (index == arr.length) {
            if (currSum - (sum - currSum) == diff)
                return 1;
            return 0;
        }

        if (dp[index][currSum] != null)
            return dp[index][currSum];

        return dp[index][currSum] = (countPartitionsWithDiff(arr, index + 1, currSum + arr[index], dp) % 1000000007
                + countPartitionsWithDiff(arr, index + 1, currSum, dp) % 1000000007) % 1000000007;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1};
        System.out.println(countPartitions(4, 0, arr));
    }
}
