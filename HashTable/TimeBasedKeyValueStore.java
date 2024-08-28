package HashTable;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// LC - 981
// https://leetcode.com/problems/time-based-key-value-store
public class TimeBasedKeyValueStore {

    HashMap<String, TreeMap<Integer, String>> keyValueStore = new HashMap<>();

    public TimeBasedKeyValueStore() {

    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> keyVal = keyValueStore.getOrDefault(key, new TreeMap<>());
        keyVal.put(timestamp, value);
        keyValueStore.put(key, keyVal);
    }

    public String get(String key, int timestamp) {
        if (keyValueStore.containsKey(key)) {
            Map.Entry<Integer, String> entry = keyValueStore.get(key).floorEntry(timestamp);
            if (entry != null)
                return entry.getValue();
            else
                return "";
        }
        return "";
    }
}
