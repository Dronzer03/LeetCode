package Graphs;

import java.util.*;

// LC - 2092
// https://leetcode.com/problems/find-all-people-with-secret
public class FindPeopleWithSecret {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<List<PairClass>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] meeting : meetings) {
            adj.get(meeting[0]).add(new PairClass(meeting[1], meeting[2]));
            adj.get(meeting[1]).add(new PairClass(meeting[0], meeting[2]));
        }

        Set<Integer> result = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        queue.offer(firstPerson);
        int[] time = new int[n];
        Arrays.fill(time, (int)1e9);
        time[0] = 0;
        time[firstPerson] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int currTime = time[node];
            result.add(node);
            for (PairClass pair : adj.get(node)) {
                if (pair.time >= currTime && pair.time < time[pair.node]) {
                    time[pair.node] = pair.time;
                    queue.offer(pair.node);
                }
            }
        }

        return new ArrayList<>(result);
    }

    class PairClass {
        int node;
        int time;

        PairClass(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }
}
