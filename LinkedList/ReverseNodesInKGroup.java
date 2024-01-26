package LinkedList;

// LC - 25
// https://leetcode.com/problems/reverse-nodes-in-k-group
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1)
            return head;

        ListNode temp = head;
        ListNode newHead = null;
        ListNode prev = null;

        while (temp != null) {
            ListNode kNode = findKNode(temp, k);
            if (newHead == null)
                newHead = kNode;
            if (kNode != null) {
                ListNode nextNode = kNode.next;
                kNode.next = null;
                ListNode currHead = reverseLL(temp);
                if (prev != null)
                    prev.next = currHead;
                prev = temp;
                temp = nextNode;
            } else {
                if (prev != null) {
                    prev.next = temp;
                }
                break;
            }
        }

        return newHead;
    }

    private ListNode findKNode(ListNode temp, int k) {
        int count = 1;
        while (count < k && temp.next != null) {
            temp = temp.next;
            count++;
        }
        if (count == k)
            return temp;
        return null;
    }

    private static ListNode reverseLL(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = head;
        ListNode curr = head.next;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        head.next = null;
        return prev;
    }
}
