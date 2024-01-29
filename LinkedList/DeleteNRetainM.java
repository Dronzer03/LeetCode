package LinkedList;

// Delete N Nodes after M Nodes - Coding Ninjas
// https://www.codingninjas.com/studio/problems/delete-n-nodes-after-m-nodes-of-a-linked-list_668903
public class DeleteNRetainM {
    public static Node getListAfterDeleteOperation(Node head, int n, int m) {
        // Write your code here.
        if (n == 0)
            return head;
        if (m == 0)
            return null;
        Node temp = head;

        int index = 1;
        while (temp != null) {
            while (index < m) {
                if (temp == null) {
                    return head;
                }
                temp = temp.next;
                index++;
            }
            index = 1;
            Node nextNode = temp.next;
            while (nextNode != null && index < n) {
                nextNode = nextNode.next;
                index++;
            }
            if (nextNode == null)
                temp.next = null;
            else
                temp.next = nextNode.next;
            temp = temp.next;
            index = 1;
        }

        return head;
    }
}
