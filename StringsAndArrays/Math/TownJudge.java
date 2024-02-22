package StringsAndArrays.Math;

// LC - 997
// https://leetcode.com/problems/find-the-town-judge
public class TownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] trustsTo = new int[n+1];
        int[] peopleTrusts = new int[n+1];

        for (int[] current : trust) {
            trustsTo[current[0]]++;
            peopleTrusts[current[1]]++;
        }

        for (int i=1; i<=n; i++) {
            if (trustsTo[i] == 0 && peopleTrusts[i] == n-1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2}};
        System.out.println(new TownJudge().findJudge(2, arr));
    }
}
