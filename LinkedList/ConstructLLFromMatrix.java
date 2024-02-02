package LinkedList;

public class ConstructLLFromMatrix {
    class Node
    {
        int data;
        Node right,down;

        Node(int data){
            this.data = data;
            right = null;
            down = null;
        }
    }
    public Node constructUtil(int arr[][], int i, int j, int m, int n) {
        if (i > n - 1 || j > m - 1)
            return null;
        // Create a new node with data from the 2D array
        Node temp = new Node(arr[i][j]);
        temp.data = arr[i][j];
        // Recursively construct the right subtree
        temp.right = constructUtil(arr, i, j + 1, m, n);
        // Recursively construct the down subtree
        temp.down = constructUtil(arr, i + 1, j, m, n);
        // Return the constructed node
        return temp;
    }

    public Node construct(int arr[][],int n)
    {
        // Call the utility function to construct the linked list
        return constructUtil(arr, 0, 0, n, n);
    }
}
