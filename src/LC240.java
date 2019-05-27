public class LC240 {
    //Search a 2D Matrix II
    //从最右上角开始, 因为每一个基准的同行都比它小, 同列都比它大, 判断是否进行位移
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int c = matrix[0].length - 1, r = 0;
        while (c >= 0 && r <= matrix.length - 1) {
            if (target == matrix[r][c]) {
                return true;
            } else if (target < matrix[r][c]) {
                c--;
            } else r++;
        }
        return false;
    }
}
