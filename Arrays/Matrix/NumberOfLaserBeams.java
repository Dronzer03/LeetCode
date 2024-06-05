package Arrays.Matrix;

// LC - 2125
// https://leetcode.com/problems/number-of-laser-beams-in-a-bank
public class NumberOfLaserBeams {
    public int numberOfBeams(String[] bank) {
        int beams = 0;
        int last = 0;
        for (String str : bank) {
            int count = 0;
            for (int i=0; i < str.length(); i++) {
                if (str.charAt(i) == '1')
                    count++;
            }
            if (count > 0) {
                if (last > 0) {
                    beams += count * last;
                }
                last = count;
            }
        }
        return beams;
    }
}
