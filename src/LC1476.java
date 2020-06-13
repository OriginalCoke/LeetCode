public class LC1476 {
    //1476. Subrectangle Queries
    class SubrectangleQueries {
        int[][] A;

        public SubrectangleQueries(int[][] rectangle) {
            A = rectangle;
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    A[i][j] = newValue;
                }
            }
        }

        public int getValue(int row, int col) {
            return A[row][col];
        }
    }
}
