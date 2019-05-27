public class LC74 {
    //Search a 2D Matrix
    //m*n 的坐标转换, 如果矩阵大小是 r*c, 则 A[x][y]的值可以表示为 B[x*c+y], 还原同理
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int r = matrix.length, c = matrix[0].length;
        int start = 0, end = r * c - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (matrix[mid / c][mid % c] == target) {
                return true;
            }
            if (matrix[mid / c][mid % c] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
    //TC: log(r*c)
}
