package Arrays.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// LC - 56
// https://leetcode.com/problems/merge-intervals
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        int[] curr = intervals[0];

        for (int index = 1; index < intervals.length; index++) {
            if (intervals[index][0] <= curr[1]) {
                curr[1] = Math.max(curr[1], intervals[index][1]);
            } else {
                curr = intervals[index];
                result.add(intervals[index]);
            }
        }

        int[][] res = new int[result.size()][2];
        int index = 0;
        for (int[] interval : result) {
            res[index++] = interval;
        }
        return res;
    }
}
