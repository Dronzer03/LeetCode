import java.util.*;
import java.util.stream.Collectors;

public class Mehnat {
    public int maxPoints = 0;

    public static void main(String[] args) {
//        new Mehnat().test();
        int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        int[] test = {1,4,4};
//        System.out.println(new Mehnat().minSubArrayLen(10, test));
//        System.out.println(new Mehnat().calculate("9989796959493929108878685848382811776757473727136656463626145545352515443424163323137221001020304050"));

    }

    public int countSeniors(String[] details) {
        return Math.toIntExact(Arrays.stream(details).map(s -> s.substring(11, 13))
                .mapToInt(s -> Integer.parseInt(s))
                .filter(age -> age > 60).count());
    }

    public void test() {
        int n = 5;
        List<Node> cities = new ArrayList<>();
//        cities.add(new Node(0, 7));
//        cities.add(new Node(8, 10));
//        cities.add(new Node(3, 4));
//        cities.add(new Node(5, 0));
//        cities.add(new Node(9, 12));

        cities.add(new Node(0, 0));
        cities.add(new Node(3, 0));
        cities.add(new Node(3, 3));
        cities.add(new Node(1, 2));
//        cities.add(new Node(5, 0));
//        cities.add(new Node(9, 12));

        List<Node> ans = cities.stream().sorted(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.y - o1.y;
            }
        }).collect(Collectors.toList());
        System.out.println(ans);
    }

    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        int max = 0;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
