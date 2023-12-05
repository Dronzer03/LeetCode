package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String s : strs) {
            int[] arr = new int[26];
            for (char c : s.toCharArray()) {
                arr[c - 'a'] += 1;
            }
            String arrStr = Arrays.toString(arr);
            if (result.containsKey(arrStr)) {
                result.get(arrStr).add(s);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(s);
                result.put(arrStr, newList);
            }
        }
        return new ArrayList<>(result.values());
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] arr = { "args", "arsg" };
        groupAnagrams.groupAnagrams(arr).stream().forEach(list -> System.out.println(list.toString()));
    }
}
