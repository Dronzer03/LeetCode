package HashTable;

import java.util.LinkedHashMap;
import java.util.Map;

// LC - 12
// https://leetcode.com/problems/integer-to-roman
public class IntToRoman {

    public String intToRoman(int num) {
        Map<Integer, String> intToRoman = new LinkedHashMap<>();
        intToRoman.put(1000, "M");
        intToRoman.put(900, "CM");
        intToRoman.put(500, "D");
        intToRoman.put(400, "CD");
        intToRoman.put(100, "C");
        intToRoman.put(90, "XC");
        intToRoman.put(50, "L");
        intToRoman.put(40, "XL");
        intToRoman.put(10, "X");
        intToRoman.put(9, "IX");
        intToRoman.put(5, "V");
        intToRoman.put(4, "IV");
        intToRoman.put(1, "I");
        String res = "";
        
        for (Map.Entry<Integer, String> entry : intToRoman.entrySet()) {
            int key = entry.getKey();
            int count = num / key;
            if (count > 0) {
                String val = entry.getValue();
                while (count > 0) {
                    res += val;
                    count--;
                }
            }
            num = num % key;
        }
        return res;
    }
    
}
