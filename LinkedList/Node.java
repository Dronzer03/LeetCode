package LinkedList;

public class Node {
    public int data;
    public Node next;
    public Node prev;
    public Node child;
    public Node random;

    Node() {
        this.data = 0;
        this.next = null;
        this.prev = null;
        this.child = null;
        this.random = null;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
        this.child = null;
        this.random = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
        this.prev = next;
        this.child = null;
        this.random = null;
    }
}
