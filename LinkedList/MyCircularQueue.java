package LinkedList;

// Queue using LL
// LC - 622
// https://leetcode.com/problems/design-circular-queue
public class MyCircularQueue {
    class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    public int size = 0;
    public int nodes = 0;
    public Node head = null;
    public Node tail = null;

    public MyCircularQueue(int k) {
        this.size = k;
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
        }
        tail.next = node;
        node.next = head;
        tail = node;
        nodes++;
        return true;
    }

    public boolean deQueue() {
        if (head == null)
            return false;
        if (nodes == 1) {
            head = null;
            tail = null;
            nodes --;
            return true;
        }
        tail.next = head.next;
        head = tail.next;
        nodes--;
        return true;
    }

    public int Front() {
        if (head == null)
            return -1;
        return head.val;
    }

    public int Rear() {
        if (head == null)
            return -1;
        return tail.val;
    }

    public boolean isEmpty() {
        if (head == null)
            return true;
        return false;
    }

    public boolean isFull() {
        if (nodes == size)
            return true;
        return false;
    }

    public static void main(String[] args) {
        MyCircularQueue mcq = new MyCircularQueue(2);
        mcq.enQueue(1);
        mcq.enQueue(2);
        mcq.deQueue();
        mcq.enQueue(3);
        mcq.deQueue();
        mcq.enQueue(3);
        mcq.deQueue();
        mcq.enQueue(3);
        mcq.deQueue();
        System.out.println(mcq.Front());
    }
}
