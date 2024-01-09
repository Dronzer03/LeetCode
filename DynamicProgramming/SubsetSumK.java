package DynamicProgramming;

// https://www.codingninjas.com/studio/problems/subset-sum-equal-to-k_1550954
public class SubsetSumK {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        Boolean[][] dp = new Boolean[n][k + 1];
        return checkSubSet(arr, 0, k, dp);
    }

    private static boolean checkSubSet(int[] arr, int index, int target, Boolean[][] dp) {
        if (target == 0)
            return true;

        if (index == arr.length || target < 0)
            return false;

        if (dp[index][target] != null)
            return dp[index][target];

        //take
        if(checkSubSet(arr, index+1, target - arr[index], dp) || checkSubSet(arr, index+1, target, dp))
            return true;

        return dp[index][target] = false;
    }
}
