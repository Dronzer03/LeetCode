package DynamicProgramming;

public class PaintHouse2 {
    public int paint(int[][] cost) {
        if (cost.length == 0)
            return 0;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int index = 0; index < cost[0].length; index++) {
            if (cost[0][index] < min1) {
                min2 = min1;
                min1 = cost[0][index];
            } else if (cost[0][index] < min2) {
                min2 = cost[0][index];
            }
        }

        int currMin1 = Integer.MAX_VALUE;
        int currMin2 = Integer.MAX_VALUE;

        for (int index = 1; index < cost.length; index++) {
            for (int k = 0; k < cost[index].length; k++) {
                if (cost[index - 1][k] != min1) {
                    cost[index][k] += min1;
                } else {
                    cost[index][k] += min2;
                }

                if (cost[index][k] < currMin1) {
                    currMin2 = currMin1;
                    currMin1 = cost[index][k];
                } else if (cost[index][k] < currMin2) {
                    currMin2 = cost[index][k];
                }
            }

            min1 = currMin1;
            min2 = currMin2;
            currMin1 = currMin2 = Integer.MAX_VALUE;
        }

        return min1;
    }
}
