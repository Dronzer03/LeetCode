package Arrays.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// LC - 118
// https://leetcode.com/problems/pascals-triangle
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.singletonList(1));
        if (numRows == 1)
            return result;
        result.add(Arrays.asList(1, 1));

        for (int row = 2; row < numRows; row++) {
            List<Integer> current = new ArrayList<>();
            current.add(1);
            for (int index = 1; index < row; index++) {
                current.add(result.get(row - 1).get(index - 1) + result.get(row - 1).get(index));
            }
            current.add(1);
            result.add(current);
        }
        return result;
    }
}
