package TwoPointers;

public class PaintHouse {
    public int findMinCost(int[][] cost) {
        int a = 0, b = 0, c = 0;

        for (int[] curr : cost) {
            int ca = a, cb = b, cc = c;
            a = Math.min(cb, cc) + curr[0];
            b = Math.min(ca, cc) + curr[1];
            c = Math.min(ca, cb) + curr[2];
        }

        return Math.min(a, Math.min(b, c));
    }
}
