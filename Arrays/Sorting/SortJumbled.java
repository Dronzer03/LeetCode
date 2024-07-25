package Arrays.Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// LC - 2191
// https://leetcode.com/problems/sort-the-jumbled-numbers
public class SortJumbled {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<int[]> numbers = new ArrayList<>();

        for (int n : nums) {
            int original = n;
            int mapped = 0;
            int unit = 1;
            if (n == 0) {
                numbers.add(new int[]{mapping[0], original});
                continue;
            }
            while (n != 0) {
                int digit = mapping[n % 10];
                mapped += (digit * unit);
                n /= 10;
                unit *= 10;
            }
            numbers.add(new int[]{mapped, original});
        }

        Collections.sort(numbers, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int k = 0;
        int[] res = new int[nums.length];
        for (int[] curr : numbers)
            res[k++] = curr[1];

        return res;
    }
}
