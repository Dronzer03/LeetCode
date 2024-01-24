package LinkedList;

// Sort Linked List of 0s 1s and 2s (Coding Ninjas)
// https://www.codingninjas.com/studio/problems/sort-linked-list-of-0s-1s-2s_1071937
public class Sort012 {
    public static Node sortList(Node head) {
        // Write your code here
        if (head == null || head.next == null)
            return head;

        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);

        Node zero = zeroHead;
        Node one = oneHead;
        Node two = twoHead;

        Node temp = head;

        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = temp;
            } else if (temp.data == 1) {
                one.next = temp;
                one = temp;
            } else {
                two.next = temp;
                two = temp;
            }
            temp = temp.next;
        }

        if (oneHead.next != null) {
            zero.next = oneHead.next;
        } else {
            zero.next = twoHead.next;
        }
        one.next = twoHead.next;
        two.next = null;
        return zeroHead.next;
    }
}
