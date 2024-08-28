package Arrays.Sorting;

import java.util.*;
import java.util.stream.Collectors;

// LC - 1366
// https://leetcode.com/problems/rank-teams-by-votes
public class RankTeamByVotes {
    public String rankTeams(String[] votes) {
        Map<Character, int[]> votesMap = new HashMap<>();

        for (String vote : votes) {
            for (int index = 0; index < vote.length(); index++) {
                char ch = vote.charAt(index);
                votesMap.putIfAbsent(ch, new int[vote.length()]);
                votesMap.get(ch)[index]++;
            }
        }

        int len = votes[0].length();

        return votesMap.entrySet().stream()
                .sorted((a, b) -> {
                    for (int index = 0; index < len; index++) {
                        if (a.getValue()[index] != b.getValue()[index]) {
                            return b.getValue()[index] - a.getValue()[index];
                        }
                    }
                    return 0;
                })
                .map(Map.Entry::getKey)
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        String[] votes = {"ABC","ACB","ABC","ACB","ACB"};
        System.out.println(new RankTeamByVotes().rankTeams(votes));
    }
}
