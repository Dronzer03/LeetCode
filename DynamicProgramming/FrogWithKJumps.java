package DynamicProgramming;

// GFG
// https://www.geeksforgeeks.org/problems/minimal-cost/1
public class FrogWithKJumps {
    public static void main(String[] args) {
        int[] nums1 = {10, 20, 10};
        int n = 3;
        int k = 1;

        System.out.println(new FrogWithKJumps().minimizeCost(nums1, n, k));
    }

    public int minimizeCost(int arr[], int N, int K) {
        // code here
        Integer[] dp = new Integer[N];
        return minCostJump(0, arr, N, K, dp);
    }

    private int minCostJump(int index, int[] arr, int n, int k, Integer[] dp) {
        if (index == n - 1)
            return 0;

        if (dp[index] != null)
            return dp[index];

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= k; i++) {
            if (index + i <= n - 1)
                ans = Math.min(ans, Math.abs(arr[index] - arr[index + i]) + minCostJump(index + i, arr, n, k, dp));
        }

        return dp[index] = ans;
    }
}