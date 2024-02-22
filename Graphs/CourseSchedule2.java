package Graphs;

import java.util.*;

// LC - 210
// https://leetcode.com/problems/course-schedule-ii
public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : prerequisites) {
            adj.get(edge[0]).add(edge[1]);
        }

        int indegree[] = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int i = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int index : adj.get(node)) {
                indegree[index]--;
                if (indegree[index] == 0) {
                    queue.offer(index);
                }
            }
            result[i++] = node;
        }

        return i == numCourses ? result : new int[0];
    }

    public static void main(String[] args) {
        int[][] edges = {{1,0}};
        System.out.println(Arrays.toString(new CourseSchedule2().findOrder(2, edges)));
    }
}
