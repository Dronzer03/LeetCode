package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Alien Dictionary
// https://www.geeksforgeeks.org/problems/alien-dictionary/1
public class AlienDictionary {
    public String findOrder(String[] dict, int N, int K) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++)
            adj.add(new ArrayList<>());

        for (int i=0; i<dict.length - 1; i++) {
            String a = dict[i];
            String b = dict[i+1];
            int index = 0;
            while (index < a.length() && index < b.length()) {
                if (a.charAt(index) != b.charAt(index)) {
                    adj.get(a.charAt(index) - 'a').add(b.charAt(index) - 'a');
                    break;
                }
                index++;
            }
        }

        int indegree[] = new int[K];
        for (int i = 0; i < K; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int topo[] = new int[K];
        int i = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            topo[i++] = node;

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.offer(it);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int n : topo) {
            sb.append((char)(n + (int)'a'));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] arr = new String[5];
        arr[0] = "baa";
        arr[1] = "abcd";
        arr[2] = "abca";
        arr[3] = "cab";
        arr[4] = "cada";
        System.out.println(new AlienDictionary().findOrder(arr, 5, 4));
    }
}
