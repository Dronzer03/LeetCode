package HashTable;

import java.util.HashMap;
import java.util.Map;


// LC - 359
// https://leetcode.com/problems/logger-rate-limiter
public class LoggerRateLimiter {

    Map<String, Integer> loggerMap = new HashMap<>();

    public LoggerRateLimiter() {

    }

    public boolean shouldPrintMessage(String message, int timestamp) {
        if (loggerMap.containsKey(message) && loggerMap.get(message) < timestamp) {
            return false;
        }
        loggerMap.put(message, timestamp + 10);
        return true;
    }
}
