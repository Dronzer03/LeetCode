package DynamicProgramming;

 /*
 You are given maximum initial energy k (in hundreds) and n Len array A denoting wind speed on n days,
 he is stuck on a boat , each day he decides to travel he will move ahead A[i] Dist and his energy decreases by 1 and
 if he decides to stay put his energy increases by 1.
 What is the maximum distance he can travel without dropping his energy to negative after n days
  */
public class MaxEnergy {
    int maxE;
    public int maxDistance(int[] wind, int k) {
        this.maxE = k;
        Integer[][] dp = new Integer[wind.length][k];
        return findMaxDistance(wind, k, 0, dp);
    }

     private int findMaxDistance(int[] wind, int k, int index, Integer[][] dp) {
        if (index == wind.length)
            return 0;
        if (k > maxE) {
            k = maxE;
        }
        if (dp[index][k] != null)
            return dp[index][k];

        int take = 0;
        if (k > 0 && wind[index] > 0) {
            take = wind[index] + findMaxDistance(wind, k - 1, index + 1, dp);
        }
        int notTake = findMaxDistance(wind, k + 1, index + 1, dp);

        return dp[k][index] = Math.max(take, notTake);
     }
 }
