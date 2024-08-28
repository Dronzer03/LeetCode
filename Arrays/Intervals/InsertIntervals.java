package Arrays.Intervals;

import java.util.ArrayList;
import java.util.List;

// LC - 57
// https://leetcode.com/problems/insert-interval
public class InsertIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int index = 0;

        while (index < intervals.length && intervals[index][1] < newInterval[0]) {
            result.add(intervals[index++]);
        }

        while (index < intervals.length && intervals[index][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
            index++;
        }

        result.add(newInterval);

        while (index < intervals.length)
            result.add(intervals[index++]);

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals ={{1,3},{6,7},{8,9}};
        int[] toInsert = {5,9};

        System.out.println(new InsertIntervals().insert(intervals, toInsert));;
    }
}
