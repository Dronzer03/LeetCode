package Arrays.Greedy;

import java.util.Arrays;

// LC - 135
// https://leetcode.com/problems/candy
public class Candy {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);

        for (int index = 0; index < ratings.length - 1; index++) {
            if (ratings[index] > ratings[index + 1]) {
                candy[index] = candy[index + 1] + 1;
            }
            if (ratings[index + 1] > ratings[index]) {
                candy[index + 1] = candy[index] + 1;
            }
        }

        for (int index = ratings.length - 1; index > 0; index--) {
            if (ratings[index - 1] > ratings[index] && candy[index - 1] <= candy[index]) {
                candy[index - 1] = candy[index] + 1;
            }
            if (ratings[index] > ratings[index - 1] && candy[index] <= candy[index - 1]) {
                candy[index] = candy[index - 1] + 1;
            }
        }

        int total = 0;
        for (int n : candy)
            total += n;
        return total;
    }
}
