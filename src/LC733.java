public class LC733 {
    //Flood Fill
    //DFS
    int m, n;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int v = image[sr][sc], m = image.length, n = image[0].length;
        boolean[][] visited = new boolean[m][n];
        dfs(image, visited, sr, sc, newColor, v);
        return image;
    }

    public void dfs(int[][] A, boolean[][] visited, int i, int j, int color, int v) {
        if (i < 0 || i >= A.length || j < 0 || j >= A[0].length || A[i][j] != v || visited[i][j]) return;
        A[i][j] = color;
        visited[i][j] = true;
        dfs(A, visited, i + 1, j, color, v);
        dfs(A, visited, i - 1, j, color, v);
        dfs(A, visited, i, j + 1, color, v);
        dfs(A, visited, i, j - 1, color, v);
    }
}
