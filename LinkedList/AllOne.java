package LinkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Not all cases are working but good try mate!
// LC - 432
// https://leetcode.com/problems/all-oone-data-structure
public class AllOne {
    Bucket head = new Bucket(Integer.MIN_VALUE);
    Bucket tail = new Bucket(Integer.MAX_VALUE);

    Map<Integer, Bucket> frequencyBucketMap = new HashMap<>();
    Map<String, Integer> keyCountMap = new HashMap<>();

    public AllOne() {
        head.next = tail;
        tail.prev = head;
    }

    class Bucket {
        int frequency;
        Set<String> keys;
        Bucket prev;
        Bucket next;

        Bucket(int frequency) {
            this.frequency = frequency;
            this.keys = new HashSet<>();
        }
    }

    public void inc(String key) {
        if (keyCountMap.containsKey(key)) {
            int currentFrequency = keyCountMap.get(key);
            Bucket currentBucket = frequencyBucketMap.get(currentFrequency);
            currentBucket.keys.remove(key);

            int updatedFrequency = currentFrequency + 1;
            keyCountMap.put(key, updatedFrequency);
            Bucket newBucket = frequencyBucketMap.get(updatedFrequency);
            if (newBucket == null) {
                // create new bucket
                newBucket = new Bucket(updatedFrequency);
                newBucket.keys.add(key);
                newBucket.next = currentBucket.next;
                newBucket.prev = currentBucket;
                currentBucket.next = newBucket;
                newBucket.next.prev = newBucket;
                frequencyBucketMap.put(updatedFrequency, newBucket);
            }

            if (currentBucket.keys.size() == 0) {
                // deleteCurrentBucket
                deleteBucket(currentBucket);
            }
        } else {
            keyCountMap.put(key, 1);
            if (head.next.frequency != 1) {
                Bucket newBucket = new Bucket(1);
                newBucket.keys.add(key);
                newBucket.next = head.next;
                newBucket.prev = head;
                head.next = newBucket;
                newBucket.next.prev = newBucket;
                frequencyBucketMap.put(1, newBucket);
            } else {
                frequencyBucketMap.get(1).keys.add(key);
                keyCountMap.put(key, 1);
            }
        }
    }

    public void deleteBucket(Bucket currentBucket) {
        currentBucket.prev.next = currentBucket.next;
        currentBucket.next.prev = currentBucket.prev;
        currentBucket.prev = null;
        currentBucket.next = null;
        frequencyBucketMap.remove(currentBucket.frequency);
    }

    public void dec(String key) {
        if (keyCountMap.containsKey(key)) {
            int currentFrequency = keyCountMap.get(key);
            Bucket currentBucket = frequencyBucketMap.get(currentFrequency);
            currentBucket.keys.remove(key);

            int updatedFrequency = currentFrequency - 1;
            keyCountMap.put(key, updatedFrequency);
            Bucket newBucket = frequencyBucketMap.get(updatedFrequency);
            if (newBucket == null) {
                // create new bucket
                newBucket = new Bucket(updatedFrequency);
                newBucket.keys.add(key);
                newBucket.next = currentBucket.next;
                newBucket.prev = currentBucket;
                currentBucket.next = newBucket;
                newBucket.next.prev = newBucket;
                frequencyBucketMap.put(updatedFrequency, newBucket);
            }

            if (currentBucket.keys.isEmpty()) {
                // deleteCurrentBucket
                deleteBucket(currentBucket);
            }
        }
    }

    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("b");
        allOne.dec("b");
        allOne.dec("b");
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());
    }
}
