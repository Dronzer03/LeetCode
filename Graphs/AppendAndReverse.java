package Graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
    You are given two strings, P and Q consisting of characters 'a' and 'b'.

    At any given point you can perform two kind of operations on the string P:

    You either append character a to P.
    You append character b to P and then you reverse P.
    You can perform any of these operations any number of times.

    You have to tell me whether it is possible for P to be equal to Q, after performing such operations?

    An example:
    P = a, Q = baa. this will return true,
    P = b, Q = ab, this will return false
 */
public class AppendAndReverse {
    public boolean appendAndReverse(String p, String q) {
        if (p.equals(q))
            return true;

        Queue<String> queue = new LinkedList<>();

        queue.offer(p);

        while (true) {
            String current = queue.poll();
            if (current.equals(q))
                return true;
            if (current.length() > q.length())
                return false;

            StringBuilder sb = new StringBuilder(current);
            queue.offer(sb.append('a').toString());
            sb.setLength(current.length());
            queue.offer(sb.append('b').reverse().toString());
        }
    }

    public static void main(String[] args) {
        System.out.println(new AppendAndReverse().appendAndReverse("a", "baa"));
        System.out.println(new AppendAndReverse().appendAndReverse("a", "ab"));
    }
}
