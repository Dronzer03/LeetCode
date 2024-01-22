package HashSet;

import java.util.*;

public class PlayersWithZeroOrOneLosses {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> winners = new HashSet<>();
        Set<Integer> oneLoss = new HashSet<>();
        Set<Integer> losers = new HashSet<>();

        for (int match = 0; match < matches.length; match++) {
            int winner = matches[match][0];
            int loser = matches[match][1];

            if (!oneLoss.contains(winner) && !losers.contains(winner))
                winners.add(winner);

            if (winners.contains(loser)) {
                winners.remove(loser);
                oneLoss.add(loser);
                continue;
            }

            if (!oneLoss.contains(loser) && !losers.contains(loser)) {
                oneLoss.add(loser);
                continue;
            }

            if (oneLoss.contains(loser)) {
                oneLoss.remove(loser);
                losers.add(loser);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(winners.stream().sorted().toList());
        result.add(oneLoss.stream().sorted().toList());
        return result;
    }

    public List<List<Integer>> findWinnersOptimal(int[][] matches) {
        Map<Integer, Integer> losses = new HashMap<>();

        for (int match = 0; match < matches.length; match++) {
            losses.put(matches[match][0], losses.getOrDefault(matches[match][0], 0));
            losses.put(matches[match][1], losses.getOrDefault(matches[match][1], 0) + 1);
        }

        List<List<Integer>> result = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        for(Integer player : losses.keySet())
            if(losses.get(player) <= 1)
                result.get(losses.get(player)).add(player);

        Collections.sort(result.get(0));
        Collections.sort(result.get(1));
        return result;
    }
}
