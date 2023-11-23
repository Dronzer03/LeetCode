package HashTable;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character c1 = s.charAt(i);
            Character c2 = t.charAt(i);

            if ((sMap.containsKey(c1) && sMap.get(c1) != c2)
                    || (tMap.containsKey(c2) && tMap.get(c2) != c1)) {
                return false;
            }

            sMap.put(c1, c2);
            tMap.put(c2, c1);
        }

        return true;
    }
}
