package Graphs;

import java.util.*;

public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target)
            return 0;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int index = 0; index < routes.length; index++) {
            for (int stop : routes[index]) {
                List<Integer> list = map.getOrDefault(stop, new ArrayList<>());
                list.add(index);
                map.put(stop, list);
            }
        }

        if (map.get(source) == null)
            return -1;

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        for (int route : map.get(source)) {
            queue.add(route);
            visited.add(route);
        }

        int busCount = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i=0; i<size; i++) {
                int route = queue.poll();
                for (int stop : routes[route]) {
                    if (stop == target)
                        return busCount;

                    for (int nextRoute : map.get(stop)) {
                        if (!visited.contains(nextRoute)) {
                            queue.offer(nextRoute);
                            visited.add(nextRoute);
                        }
                    }
                }
            }

            busCount++;
        }

        return -1;
    }
}
