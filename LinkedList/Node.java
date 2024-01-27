package LinkedList;

public class Node {
    public int data;
    public Node next;
    public Node prev;
    public Node child;

    Node() {
        this.data = 0;
        this.next = null;
        this.prev = null;
        this.child = null;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
        this.child = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
        this.prev = next;
        this.child = null;
    }
}
