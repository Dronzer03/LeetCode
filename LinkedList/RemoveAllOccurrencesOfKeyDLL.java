package LinkedList;

// Coding Ninjas
// https://www.codingninjas.com/studio/problems/delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list_8160461
public class RemoveAllOccurrencesOfKeyDLL {
    public static Node deleteAllOccurrences(Node head, int k) {
        // Write your code here.
        if (head == null)
            return null;

        while (head!=null && head.data == k)
            head = head.next;
        if (head == null)
            return head;
        head.prev = null;

        Node temp = head.next;
        Node prev = head;

        while (temp != null) {
            if (temp.data == k)
                temp = temp.next;
            else {
                prev.next = temp;
                temp.prev = prev;
                prev = temp;
                temp = temp.next;
            }
        }
        prev.next = null;
        return head;
    }
}
