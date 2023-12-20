package DynamicProgramming;

public class FiboUsingDp {

    // Using Memoization
    public static int fibo(int n, int[] dp) {
        if (n <= 1)
            return n;

        if (dp[n] != -1)
            return dp[n];

        return dp[n] = fibo(n - 1, dp) + fibo(n - 2, dp);
    }

    // Using Tabulation
    public static int fiboTabular(int n, int[] dp) {
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        // 0 1 1 2 3 5
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++)
            dp[i] = -1;
        System.out.println(fibo(n, dp));
        System.out.println(fiboTabular(n, dp));
    }
}
