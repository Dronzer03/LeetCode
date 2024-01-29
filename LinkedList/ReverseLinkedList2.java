package LinkedList;

// Reverse Linked List 2
// LC - 92
// https://leetcode.com/problems/reverse-linked-list-ii
public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null)
            return head;

        int index = 1;
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null && index < right) {
            if (index < left) {
                prev = temp;
            }
            temp = temp.next;
            index++;
        }

        ListNode front = temp.next;
        temp.next = null;
        if (prev == null || left == 1) {
            ListNode newHead = reverse(head);
            head.next = front;
            return newHead;
        }

        ListNode leftNode = prev.next;
        prev.next = reverse(leftNode);
        leftNode.next = front;
        return head;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
}
