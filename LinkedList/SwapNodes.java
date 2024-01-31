package LinkedList;

// LC - 1721
// https://leetcode.com/problems/swapping-nodes-in-a-linked-list
public class SwapNodes {
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        ListNode temp = head;
        ListNode left = head;
        ListNode right = head;
        int node = 1;
        while (temp != null) {
            if (node <= k) {
                left = temp;
            } else {
                right = right.next;
            }
            temp = temp.next;
            node++;
        }
        int val = right.val;
        right.val = left.val;
        left.val = val;
        return head;
    }
}
