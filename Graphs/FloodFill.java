package Graphs;

// LC - 733
// https://leetcode.com/problems/flood-fill
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startingColor = image[sr][sc];
        boolean[][] visited = new boolean[image.length][image[0].length];
        floodFillImage(image, sr, sc, color, startingColor, visited);
        return image;
    }

    private void floodFillImage(int[][] image, int sr, int sc, int color, int startingColor, boolean[][] visited) {
        image[sr][sc] = color;
        visited[sr][sc] = true;

        if (sr - 1 >= 0 && !visited[sr - 1][sc] && image[sr - 1][sc] == startingColor)
            floodFillImage(image, sr - 1, sc, color, startingColor, visited);

        if (sr + 1 < image.length && !visited[sr + 1][sc] && image[sr + 1][sc] == startingColor)
            floodFillImage(image, sr + 1, sc, color, startingColor, visited);

        if (sc - 1 >= 0 && !visited[sr][sc - 1] && image[sr][sc - 1] == startingColor)
            floodFillImage(image, sr, sc - 1, color, startingColor, visited);

        if (sc + 1 < image[0].length && !visited[sr][sc + 1] && image[sr][sc + 1] == startingColor)
            floodFillImage(image, sr, sc + 1, color, startingColor, visited);
    }
}
