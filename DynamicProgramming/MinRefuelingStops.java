package DynamicProgramming;

public class MinRefuelingStops {
    int tar;
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        this.tar = target;
        int result = minStops(0, startFuel, 0, stations);
        return result >= 1001 ? -1 : result;
    }

    private int minStops(int position, int fuel, int index, int[][] stations) {
        if (position + fuel >= tar)
            return 0;

        if (index == stations.length || position + fuel < stations[index][0])
            return 1001;

        int take = 1 + minStops(stations[index][0], fuel - (stations[index][0] - position) + stations[index][1], index + 1, stations);
        int notTake = minStops(position, fuel, index + 1, stations);

        return Math.min(take, notTake);
    }
}
