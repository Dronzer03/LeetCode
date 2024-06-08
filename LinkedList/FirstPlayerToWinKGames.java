package LinkedList;

import java.util.Deque;
import java.util.LinkedList;

// LC - 3175
// https://leetcode.com/problems/find-the-first-player-to-win-k-games-in-a-row
public class FirstPlayerToWinKGames {
    public int findWinningPlayer(int[] skills, int k) {
        int winnerIndex = 0;
        int currWinner = skills[0];
        int wins = 0;
        for (int index = 1; index < skills.length; index++) {
            if (skills[index] > currWinner) {
                currWinner = skills[index];
                wins = 1;
                winnerIndex = index;
            } else {
                wins++;
            }
            if (wins == k) {
                return winnerIndex;
            }
        }

        return winnerIndex;
    }


    // Brute Force
    public int findWinningPlayerBrute(int[] skills, int k) {
        Deque<int[]> deque = new LinkedList<>();

        for (int index = 0; index < skills.length; index++) {
            int[] current = {skills[index], index};
            deque.offer(current);
        }

        int winner = -1;
        int wins = 0;
        while (deque.size() > 1) {
            int[] first = deque.pollFirst();
            int[] second = deque.pollFirst();
            if (first[0] > second[0]) {
                deque.addFirst(first);
                deque.addLast(second);
                if (winner == first[0]) {
                    wins++;
                    if (wins == k)
                        return first[1];
                } else {
                    winner = first[0];
                    wins = 1;
                }
            } else {
                deque.addFirst(second);
                deque.addLast(first);
                if (winner == second[0]) {
                    wins++;
                    if (wins == k)
                        return second[1];
                } else {
                    winner = second[0];
                    wins = 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {16,4,7,17};
        int k = 562084119;
        System.out.println(new FirstPlayerToWinKGames().findWinningPlayer(nums, k));
    }
}
