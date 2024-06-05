package HashTable;

import java.util.*;

// LC - 451
// https://leetcode.com/problems/sort-characters-by-frequency
public class FrequencySort {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        String str = "";
        PriorityQueue<Character> pq = new PriorityQueue<>((c1, c2)->map.get(c2)-map.get(c1));
        for(char ch:map.keySet()) {
            pq.add(ch);
        }

        while (!pq.isEmpty()) {
            char ch = pq.poll();
            for (int i=0; i<map.get(ch); i++)
                str += ch;
        }

        return str;
    }
}
