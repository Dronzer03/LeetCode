package Arrays;

// LC - 1094
// https://leetcode.com/problems/car-pooling
public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {

        int[] freq = new int[1001];

        for (int[] trip : trips) {
            freq[trip[1]] += trip[0];
            freq[trip[2]] -= trip[0];
        }

        for (int index = 0; capacity >=0 && index < 1001; index++) {
            capacity -= freq[index];
        }

        return capacity >= 0;
    }
}
