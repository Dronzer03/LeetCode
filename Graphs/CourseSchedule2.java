package Graphs;

import java.util.*;

// LC - 210
// https://leetcode.com/problems/course-schedule-ii
public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int index=0; index<numCourses; index++)
            adj.add(new ArrayList<>());

        int[] indegree = new int[numCourses];

        for (int[] edge : prerequisites) {
            adj.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int index = 0; index < numCourses; index++) {
            if (indegree[index] == 0) {
                queue.offer(index);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            List<Integer> current = adj.get(node);
            result[index++] = node;
            for (int n : current) {
                indegree[n]--;
                if (indegree[n] == 0) {
                    queue.offer(n);
                }
            }
        }

        if (index == numCourses)
            return result;
        return new int[0];
    }

    public static void main(String[] args) {
        int[][] edges = {{1,0}};
        System.out.println(Arrays.toString(new CourseSchedule2().findOrder(2, edges)));
    }
}
