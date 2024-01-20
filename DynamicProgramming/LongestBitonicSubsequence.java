package DynamicProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class LongestBitonicSubsequence {
    public static int longestBitonicSequence(int[] arr, int n) {
        // Write your code here.
        int[] dp1 = longestIncreasingSubsequence(arr);
        arr = reverse(arr);
        int[] dp2 = longestIncreasingSubsequence(arr);
        int max = 0;
        for (int i=0; i<n; i++)
            max = Math.max(max, dp1[i] + dp2[n - i - 1] - 1);
        return max;
    }

    private static int[] reverse(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return arr;
    }

    private static int[] longestIncreasingSubsequence(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        for (int index = 0; index < arr.length; index++) {
            for (int prev = 0; prev < index; prev++) {
                if (arr[index] > arr[prev]) {
                    dp[index] = Math.max(dp[index], dp[prev] + 1);
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,2};
        System.out.println(longestBitonicSequence(arr, 4));
    }
}
