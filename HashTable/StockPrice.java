package HashTable;

import java.util.*;

// LC - 2034
// https://leetcode.com/problems/stock-price-fluctuation
public class StockPrice {

    Map<Integer, Integer> stockPriceMap = new HashMap<>();
    Map<Integer, Integer> occurrences = new HashMap<>();
    TreeSet<Integer> keySet = new TreeSet<>();
    int currentTimestamp = 0;
    int currentPrice = 0;

    public StockPrice() {

    }

    public void update(int timestamp, int price) {
        if (timestamp >= currentTimestamp) {
            currentPrice = price;
            currentTimestamp = timestamp;
        }

        if (stockPriceMap.containsKey(timestamp)) {
            int oldPrice = stockPriceMap.get(timestamp);
            int currentOccurrences = occurrences.get(oldPrice);
            if (currentOccurrences == 1) {
                occurrences.remove(oldPrice);
                keySet.remove(oldPrice);
            } else {
                occurrences.put(oldPrice, currentOccurrences - 1);
            }
        }
        stockPriceMap.put(timestamp, price);
        occurrences.put(price, occurrences.getOrDefault(price, 0) + 1);
        keySet.add(price);
    }

    public int current() {
        return currentPrice;
    }

    public int maximum() {
        return keySet.last();
    }

    public int minimum() {
        return keySet.first();
    }
}
