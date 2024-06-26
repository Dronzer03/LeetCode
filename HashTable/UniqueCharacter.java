package HashTable;

// LC - 387
// https://leetcode.com/problems/first-unique-character-in-a-string
public class UniqueCharacter {
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        for (char ch : s.toCharArray())
            map[ch - 'a']++;
        for (int i=0; i<s.length(); i++)
            if (map[s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
}
