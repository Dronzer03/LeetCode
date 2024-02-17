package DynamicProgramming;

import java.util.Collections;
import java.util.PriorityQueue;

// LC - 1642
// https://leetcode.com/problems/furthest-building-you-can-reach
public class FurthestBuildingYouCanReach {
    // Working Solution but exceeds TL and DP Exceeds Memory Limit
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        return furthestBuilding(heights, bricks, ladders, 0);
    }

    private static int furthestBuilding(int[] heights, int bricks, int ladders, int index) {
        if (index == heights.length - 1)
            return index;

        if (heights[index + 1] <= heights[index]) {
            return furthestBuilding(heights, bricks, ladders, index + 1);
        }

        if (bricks == 0 && ladders == 0)
            return index;

        int usingBricks = index;
        if (heights[index + 1] - heights[index] <= bricks) {
            usingBricks = furthestBuilding(heights, bricks - (heights[index + 1] - heights[index]), ladders, index + 1);
        }
        int usingLadders = index;
        if (ladders > 0) {
            usingLadders = furthestBuilding(heights, bricks, ladders - 1, index + 1);
        }
        return Math.max(usingLadders, usingBricks);
    }

    public static void main(String[] args) {
        int[] buildings = {4, 12, 2, 7, 3, 18, 20, 3, 19};
        System.out.println(furthestBuilding(buildings, 10, 2));
        System.out.println(furthestBuildingGreedy(buildings, 10, 2));
    }

    public static int furthestBuildingGreedy(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> gaps = new PriorityQueue<>(Collections.reverseOrder());
        int index = 0;
        for (; index < heights.length - 1; index++) {
            if (heights[index + 1] <= heights[index])
                continue;

            int gap = heights[index + 1] - heights[index];
            bricks -= gap;
            gaps.offer(gap);

            if (bricks < 0) {
                bricks += gaps.poll();
                if (ladders > 0)
                    ladders--;
                else
                    return index;
            }
        }
        return index;
    }
}
