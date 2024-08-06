package Arrays.Greedy;

import java.util.Arrays;

// LC - 134
// https://leetcode.com/problems/gas-station
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum())
            return -1;

        int total = 0;
        int result = 0;

        for (int index = 0; index < gas.length; index++) {
            total += gas[index] - cost[index];

            if (total < 0) {
                total = 0;
                result = index + 1;
            }
        }

        return result;
    }
}
