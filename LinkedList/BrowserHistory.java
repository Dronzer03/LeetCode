package LinkedList;

// LC - 1472
// https://leetcode.com/problems/design-browser-history
public class BrowserHistory {
    class Node{
        String url;
        Node next, prev;
        public Node(String url) {
            this.url = url;
            next = null;
            prev = null;
        }
    }

    Node home = null;
    Node curr;

    public BrowserHistory(String homepage) {
        home = new Node(homepage);
        curr = home;
    }

    public void visit(String url) {
        Node n = new Node(url);
        curr.next = n;
        n.prev = curr;
        curr = n;
    }

    public String back(int steps) {
        while (steps > 0 && curr != home) {
            curr = curr.prev;
            steps--;
        }
        return curr.url;
    }

    public String forward(int steps) {
        while (curr.next != null && steps > 0) {
            curr = curr.next;
            steps--;
        }
        return curr.url;
    }
}
