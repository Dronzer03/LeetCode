package Arrays.Intervals;

import java.util.ArrayList;
import java.util.List;

// Note: Not sure how this is working - Let me know if anyone does
// But keep different one for left, different for right and put new in middle
// LC - 57
// https://leetcode.com/problems/insert-interval
public class InsertIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();

        for (int[] interval : intervals) {
            if (interval[0] > newInterval[1]) {
                list.add(interval);
            } else if (interval[1] < newInterval[0]) {
                list.add(interval);
            } else {
                newInterval[0] = Math.min(newInterval[0],interval[0]);
                newInterval[1] = Math.max(newInterval[1],interval[1]);
            }
        }

        list.add(newInterval);
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals ={{1,3},{6,9}};
        int[] toInsert = {2,5};

        System.out.println(new InsertIntervals().insert(intervals, toInsert));;
    }
}
