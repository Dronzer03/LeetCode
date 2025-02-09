package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DistinctColors {
    public int[] queryResults(int limit, int[][] queries) {
        int[] result = new int[queries.length];
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> colors = new HashMap<>();
        int index = 0;

        for (int[] query : queries) {
            int ball = query[0];
            int color = query[1];
            if (map.containsKey(ball)) {
                int prevColor = colors.get(ball);
                colors.put(prevColor, colors.get(prevColor) - 1);
                if (colors.get(prevColor) == 0)
                    colors.remove(prevColor);
            }
            colors.put(color, map.getOrDefault(color, 0) + 1);
            map.put(ball, color);
            result[index++] = colors.size();
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] queries = {{1,3}, {2,4}, {1,5}};
        System.out.println(Arrays.toString(new DistinctColors().queryResults(2, queries)));
    }
}
