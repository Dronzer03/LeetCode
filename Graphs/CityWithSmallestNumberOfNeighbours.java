package Graphs;

// LC - 1334
// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance
public class CityWithSmallestNumberOfNeighbours {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] matrix = new int[n][n];
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix.length; j++) {
                matrix[i][j] = (int)1e9;
                if (i == j)
                    matrix[i][j] = 0;
            }
        }

        for (int[] edge : edges) {
            matrix[edge[0]][edge[1]] = edge[2];
            matrix[edge[1]][edge[0]] = edge[2];
        }

        for (int via = 0; via < matrix.length; via++) {
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix.length; col++) {
                    matrix[row][col] = Math.min(matrix[row][col], matrix[row][via] + matrix[via][col]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int city = 0;
        for (int i=0; i<n; i++) {
            int count = 0;
            for (int j =0; j<n;j++) {
                if (i!=j && matrix[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= min) {
                min = count;
                city = i;
            }
        }

        return city;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1,2}, {0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}};
        System.out.println(new CityWithSmallestNumberOfNeighbours().findTheCity(5, edges, 2));
    }
}
