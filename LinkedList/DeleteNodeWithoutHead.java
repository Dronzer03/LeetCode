package LinkedList;

// LC - 237
// https://leetcode.com/problems/delete-node-in-a-linked-list
public class DeleteNodeWithoutHead {
    public void deleteNode(ListNode node) {
        ListNode prev = null;
        while (node.next != null) {
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        if (prev != null)
            prev.next = null;
    }

    public void deleteNodeBetter(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
