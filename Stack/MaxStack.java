package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MaxStack {
    int nodes = 0;
    DLL dll = new DLL();
    TreeMap<Integer, List<Node>> map = new TreeMap<>();
    public void push(int x) {
        Node node = dll.add(x);
        map.putIfAbsent(x, new ArrayList<>());
        map.get(x).add(node);
        nodes++;
    }

    public int pop() {
        if (nodes == 0)
            return -1;
        Node node = dll.pop();
        map.get(node.val).remove(node);
        return node.val;
    }

    public int peek() {
        return dll.peek();
    }

    public int peekMax() {
        return nodes > 0 ? map.lastKey() : -1;
    }

    public int popMax() {
        if (nodes == 0)
            return -1;
        List<Node> nodesList = map.get(map.lastKey());
        Node node = nodesList.get(nodesList.size() - 1);
        dll.delete(node);
        nodesList.remove(node);
        nodes--;
        return node.val;
    }

    class DLL {
        Node head = new Node(-1);
        Node tail = new Node(-1);

        DLL() {
            head.next = tail;
            tail.prev = head;
        }

        public Node add(int x) {
            Node node = new Node(x);
            node.prev = tail.prev;
            node.prev.next = node;
            node.next = tail;
            tail.prev = node;
            return node;
        }

        public Node delete(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            return node;
        }

        public Node pop() {
            return delete(tail.prev);
        }

        public int peek() {
            return tail.prev.val;
        }
    }

    class Node {
        int val;
        Node prev, next;
        Node(int val) {
            this.val = val;
        }
    }
}
