package StringsAndArrays.Strings;

// LC - 2027
// https://leetcode.com/problems/minimum-moves-to-convert-string
public class MinMovesXO {
    public int minimumMoves(String s) {
        int index = 0;
        int moves = 0;
        while (index < s.length()) {
            if (s.charAt(index) == 'X') {
                moves++;
                index+=3;
            } else {
                index++;
            }
        }
        return moves;
    }
}
