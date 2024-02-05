package LinkedList;

// LC - 641
// https://leetcode.com/problems/design-circular-deque
public class CircularDeque {
    class Node {
        int val;
        Node prev, next;
        Node(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    Node head;
    Node tail;
    int maxSize = 0;
    int nodes = 0;
    public CircularDeque(int k) {
        this.maxSize = k;
    }

    public boolean insertFront(int value) {
        if (nodes == maxSize)
            return false;
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        nodes++;
        return true;
    }

    public boolean insertLast(int value) {
        if (nodes == maxSize)
            return false;
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        nodes++;
        return true;
    }

    public boolean deleteFront() {
        if (nodes == 0)
            return false;
        if (nodes == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        nodes--;
        return true;
    }

    public boolean deleteLast() {
        if (nodes == 0)
            return false;
        if (nodes == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        nodes--;
        return true;
    }

    public int getFront() {
        return nodes == 0 ? -1 : head.val;
    }

    public int getRear() {
        return nodes == 0 ? -1 : tail.val;
    }

    public boolean isEmpty() {
        return nodes == 0;
    }

    public boolean isFull() {
        return nodes == maxSize;
    }
}
