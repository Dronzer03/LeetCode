package StringsAndArrays.HashTable;

import java.util.HashMap;
import java.util.Map;

public class isValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char s1 = s.charAt(i);
            if (sMap.containsKey(s1)) {
                int count = sMap.get(s1);
                sMap.put(s1, count + 1);
            } else {
                sMap.put(s1, 1);
            }

            char t1 = t.charAt(i);
            if (tMap.containsKey(t1)) {
                int count = tMap.get(t1);
                tMap.put(t1, count + 1);
            } else {
                tMap.put(t1, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            if (!tMap.containsKey(entry.getKey()) || (entry.getValue() - tMap.get(entry.getKey()) != 0))
                return false;
        }

        return true;
    }
}
