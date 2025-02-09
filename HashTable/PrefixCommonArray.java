package HashTable;

// LC - 2657
// https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays
public class PrefixCommonArray {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] count1 = new int[A.length + 1];
        int[] count2 = new int[B.length + 1];

        int result = 0;
        int[] ans = new int[A.length];
        for (int index = 0; index < A.length; index++) {
            if (A[index] == B[index] && count1[A[index]] == 0 && count2[B[index]] == 0)
                result++;

            if (count1[A[index]] == 0 && count2[A[index]] > 0)
                result++;

            if (count2[B[index]] == 0 && count1[B[index]] > 0)
                result++;

            count1[A[index]]++;
            count2[B[index]]++;
            ans[index] = result;
        }

        return ans;
    }
}
