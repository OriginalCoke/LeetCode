import java.util.Arrays;
import java.util.Comparator;

public class LC1030 {
    //Matrix Cells in Distance Order
    //重写Array.sort, 进行哈夫曼值的比较
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] A = new int[R * C][2];
        int index = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                A[index][0] = i;
                A[index][1] = j;
                index++;
            }
        }
        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Math.abs(a[0] - r0) + Math.abs(a[1] - c0) - Math.abs(b[0] - r0) - Math.abs(b[1] - c0);
            }
        });
        return A;
    }
}
