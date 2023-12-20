package DynamicProgramming;

public class FrogJumpStairs {

    public int minimumEnergy(int arr[], int N) {
        //code here
        int[] dp = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            dp[i] = -1;
        }
        return findMinEnergy(arr, N, dp);
    }

    private int findMinEnergy(int[] arr, int n, int[] dp) {
        if (n == 0)
            return 0;

        if (dp[n] != -1)
            return dp[n];

        int oneStep = findMinEnergy(arr, n - 1, dp) + Math.abs(arr[n] - arr[n - 1]);
        int twoStep = Integer.MAX_VALUE;
        if (n > 1)
            twoStep = findMinEnergy(arr, n - 2, dp) + Math.abs(arr[n] - arr[n - 2]);

        return dp[n] = Math.min(oneStep, twoStep);
    }

    public int minimumEnergyTabulation(int arr[], int N) {
        if (arr.length == 1)
            return 0;
        int[] dp = new int[N];
        dp[0] = 0;
        dp[1] = Math.abs(arr[1] - arr[0]);
        for (int i = 2; i < N; i++) {
            dp[i] = Math.min(
                    (dp[i - 2] + Math.abs(arr[i] - arr[i - 2])),
                    (dp[i - 1] + Math.abs(arr[i] - arr[i - 1]))
            );
        }
        return dp[N-1];
    }

    public int minimumEnergyTabulationSpaceBetter(int arr[], int N) {
        if (arr.length == 1)
            return 0;
        int prev2 = 0;
        int prev1 = Math.abs(arr[1] - arr[0]);
        int curr = Integer.MAX_VALUE;
        for (int i = 2; i < N; i++) {
            curr = Math.min(
                    (prev2 + Math.abs(arr[i] - arr[i - 2])),
                    (prev1 + Math.abs(arr[i] - arr[i - 1]))
            );
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
}
