package LinkedList;

import java.util.HashMap;
import java.util.Map;

// LC - 138
// https://leetcode.com/problems/copy-list-with-random-pointer
public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;
        Map<Node, Node> map = new HashMap<>();

        Node temp = head;
        Node copyHead = null;
        while (temp != null) {
            Node copy = new Node(temp.data);
            if (copyHead == null)
                copyHead = copy;
            map.put(temp, copy);
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            Node copy = map.get(temp);
            Node next = temp.next;
            Node random = temp.random;
            if (next != null)
                copy.next = map.get(next);
            else
                copy.next = null;
            if (random != null)
                copy.random = map.get(random);
            else
                copy.random = null;
            temp = temp.next;
        }

        return copyHead;
    }
}
