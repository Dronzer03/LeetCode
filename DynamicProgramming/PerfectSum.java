package DynamicProgramming;

// GFG
// https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1
public class PerfectSum {
    public int perfectSum(int arr[], int n, int sum) {
        Integer[][] dp = new Integer[n][sum + 1];
        return sumCount(arr, sum, 0, dp);
    }

    private int sumCount(int[] arr, int sum, int index, Integer[][] dp) {
        if (index == arr.length) {
            if (sum == 0)
                return 1;
            return 0;
        }

        if (sum < 0)
            return 0;

        if (dp[index][sum] != null)
            return dp[index][sum];

        return dp[index][sum] = ((sumCount(arr, sum - arr[index], index + 1, dp) % 1000000007)
                + (sumCount(arr, sum, index + 1, dp) % 1000000007)) % 1000000007;
    }
}
