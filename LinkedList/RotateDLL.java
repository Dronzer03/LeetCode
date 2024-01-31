package LinkedList;

// Coding Ninjas - Rotate DLL
// https://www.codingninjas.com/studio/problems/rotate-dll_1115782
public class RotateDLL {
    public static Node rotateDLL(Node head, int k)
    {
        //Write your code here
        Node temp = head;
        int count = 1;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        temp.next = head;
        head.prev = temp;
        k = k % count;
        temp = head;
        while (k > 0) {
            temp = temp.next;
            k--;
        }
        temp.prev.next = null;
        temp.prev = null;
        return temp;
    }
}
