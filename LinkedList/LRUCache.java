package LinkedList;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    HashMap<Integer, Node> map = new HashMap<>();
    int capacity = 0;
    Node head = null;
    Node tail = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = new Node(key, map.get(key).val);
        //1,2,3,1
        tail.next = node;
        node.prev = tail;
        tail = tail.next;

        if (map.containsKey(key)) {
            Node currNode = map.get(key);
            if(currNode == head){
                head = head.next;
                head.prev = null;
            }else {
                currNode.prev.next = currNode.next;
                currNode.next.prev = currNode.prev;
            }
        }
        map.put(key, tail);
        return map.get(key).val;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            //Pointing
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }
        if (map.containsKey(key)) {
            Node currNode = map.get(key);
            if(currNode == head){
                head = head.next;
                head.prev = null;
            }else {
                currNode.prev.next = currNode.next;
                currNode.next.prev = currNode.prev;
            }
        }
        map.put(key, node);//1,2,3,4
        if (capacity < map.size()) {
            map.remove(head.key);
            head = head.next;
            head.prev = null;
        }
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1,1);
        lru.put(2,2);
        System.out.println(lru.get(1));
        lru.put(3,3);
        System.out.println(lru.get(2));
    }
}

class LRUCacheHashMap {
    LinkedHashMap<Integer, Integer> map;

    public LRUCacheHashMap(int capacity) {
        map = new LinkedHashMap<>(capacity, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}