public class LC1252 {
    //Cells with Odd Values in a Matrix
    //n 行 m 列, count row and column appear times and check if it's odd
    //use ^= true instead
    public int oddCells(int n, int m, int[][] indices) {
        int res = 0;
        int[] row = new int[n];
        int[] col = new int[m];
        for (int[] pair : indices) {
            row[pair[0]]++;
            col[pair[1]]++;
        }
        for (int r : row) {
            for (int c : col) {
                if ((r + c) % 2 != 0) res++;
            }
        }
        return res;
    }
}
