package Strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public int romanToInt(String s) {
        int res = 0;
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        int curr = 0, next = 0;
        for (int i=0; i<s.length()-1;i++) {
            curr = romanMap.get(s.charAt(i));
            next = romanMap.get(s.charAt(i+1));
            if (curr < next) {
                res -= curr;
            } else {
                res += curr;
            }
        }
        res += romanMap.get(s.charAt(s.length()-1));
        return res;
    }
}
