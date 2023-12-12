package StringsAndArrays.HashTable;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineMap = new HashMap<>();
        for (Character c : magazine.toCharArray()) {
            if (magazineMap.containsKey(c)) {
                int count = magazineMap.get(c);
                magazineMap.put(c, count+1);
            } else {
                magazineMap.put(c, 1);
            }
        }

        for (Character c : ransomNote.toCharArray()) {
            if (!magazineMap.containsKey(c)) {
                return false;
            } else {
                int count = magazineMap.get(c);
                if (count <= 0)
                    return false;
                else
                    magazineMap.put(c, count-1);
            }
        }
        return true;
    }
}
