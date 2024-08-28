package HashTable;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// LC - 911
// https://leetcode.com/problems/online-election
public class TopVotedCandidate {
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    int leader = -1;
    public TopVotedCandidate(int[] persons, int[] times) {
        Map<Integer, Integer> votesMap = new HashMap<>();

        for (int index = 0; index < persons.length; index++) {
            int person = persons[index];
            int time = times[index];
            votesMap.put(person, votesMap.getOrDefault(person, 0) + 1);
            if (index == 0 || votesMap.get(person) >= votesMap.get(leader)) {
                leader = person;
            }
            treeMap.put(time, leader);
        }
    }

    public int q(int t) {
        return treeMap.floorEntry(t).getValue();
    }
}
