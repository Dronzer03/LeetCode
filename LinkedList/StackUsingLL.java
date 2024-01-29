package LinkedList;

// Coding Ninjas
// https://www.codingninjas.com/studio/problems/implement-stack-with-linked-list_630475
public class StackUsingLL {
    Node head = null;
    int nodes = 0;

    int getSize()
    {
        //Write your code here
        return nodes;
    }

    boolean isEmpty()
    {
        //Write your code here
        if (nodes == 0)
            return true;
        return false;
    }

    void push(int data)
    {
        //Write your code here
        Node node = new Node(data);
        if (nodes == 0) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        nodes++;
    }

    void pop()
    {
        if (nodes > 0) {
            head = head.next;
            nodes--;
        }
        //Write your code here
    }

    int getTop()
    {
        //Write your code here
        if (nodes == 0)
            return -1;
        return head.data;
    }
}
