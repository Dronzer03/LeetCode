package HashTable;

// LC - 383
// https://leetcode.com/problems/ransom-note
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for (char ch : magazine.toCharArray()) {
            map[ch - 'a']++;
        }

        for (char ch : ransomNote.toCharArray()) {
            map[ch - 'a']--;
            if (map[ch - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
