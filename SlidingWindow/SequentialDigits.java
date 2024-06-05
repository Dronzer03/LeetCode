package SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        String number = "123456789";
        int i = 0, j = 2, k = j;
        List<Integer> output = new ArrayList<>();
        while (true) {
            int num = Integer.parseInt(number.substring(i, j));
            if (num > high) {
                return output;
            } else if (num >= low) {
                output.add(num);
            }
            i++;
            j++;
            if (number.length() < j) {
                i = 0;
                j = ++k;
                if (k == 10) {
                    return output;
                }
            }
        }
    }
}
