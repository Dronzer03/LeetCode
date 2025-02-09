package HashTable;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class StandardCache implements Rankable, DataSource {
    private final int capacity;
    volatile int time = 0;
    ConcurrentMap<Integer, Node> keys = new ConcurrentHashMap<>();
    PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Math.toIntExact(a.rank == b.rank ? a.lastAccessedTime - b.lastAccessedTime : a.rank - b.rank));
    ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    Lock readLock = reentrantReadWriteLock.readLock();
    Lock writeLock = reentrantReadWriteLock.writeLock();

    public StandardCache(int capacity) {
        this.capacity = capacity;
        time = 0;
    }

    public static void main(String[] args) {
        StandardCache standardCache = new StandardCache(3);
        standardCache.getVal(1);
        standardCache.getVal(2);
        standardCache.getVal(3);
        standardCache.getVal(4);
        standardCache.getVal(2);
        standardCache.getVal(4);
    }

    @Override
    public int get(int key) {
        return new Random().nextInt(0, 10);
    }

    public int getVal(int key) {
        readLock.lock();
        if (keys.containsKey(key)) {
            updateCache(key);
        } else {
            readLock.unlock();
            writeLock.lock();
            if (keys.size() < capacity) {
                addToCache(key);
            }else {
                evict();
                addToCache(key);
            }
            writeLock.unlock();
        }
        return keys.get(key).val;
    }

    private void updateCache(int key) {
        Node node = keys.get(key);
        readLock.unlock();
        writeLock.lock();
        pq.remove(node);
        node.lastAccessedTime = time++;
        pq.offer(node);
        writeLock.unlock();
    }

    private void evict() {
        Node node = pq.poll();
        keys.remove(node.key);
    }

    private void addToCache(int key) {
        int val = get(key);
        long rank = getRank();
        Node node = new Node(key, val);
        node.lastAccessedTime = time++;
        node.rank = rank;
        pq.offer(node);
        keys.put(key, node);
    }

    @Override
    public long getRank() {
        return new Random().nextInt(0, 1);
    }

    class Node {
        int key;
        int val;
        int lastAccessedTime;
        long rank;
        Node next, prev;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

//class DLL {
//    Node head = new Node(-1, -1);
//    Node tail = new Node(-1, -1);
//
//    int size = 0;
//
//    DLL() {
//        head.next = tail;
//        tail.prev = head;
//    }
//
//    public Node add(int key, int val) {
//        Node node = new Node(key, val);
//        node.next = tail;
//        node.prev = tail.prev;
//        tail.prev.next = node;
//        tail.prev = node;
//        return node;
//    }
//
//    public void delete(Node node) {
//        node.prev.next = node.next;
//        node.next.prev = node.prev;
//    }
//
//    public Node evict() {
//        Node node = head.next;
//        delete(node);
//        return node;
//    }
//}

interface Rankable {
    /**
     * Returns the Rank of this object, using some algorithm and potentially
     * the internal state of the Rankable.
     */
    long getRank();
}

/*
 * Remember that this is slow, relatively speaking
 */
interface DataSource {
    int get (int key);
}

