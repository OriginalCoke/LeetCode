public class LC1053 {
    //Previous Permutation With One Swap
    //从末尾往前判断, 先找到第一个不是递减的数的下标, 如果下标来到 0, 则说明原数组是非递减的, 返回原数组
    //取 i-1 的数, 也就是第一次出现递减的数, 与后面的数进行比较, 找到自己的位置, 即A[j + 1] > A[i - 1], 交换两个数的位置
    public int[] prevPermOpt1(int[] A) {
        int n = A.length - 1;
        int i = n;
        while (i > 0 && A[i - 1] <= A[i]) i--;
        if (i <= 0) return A;
        int j = i - 1;
        while (j + 1 <= n && A[j + 1] < A[i - 1]) j++;
        swap(A, i - 1, j);
        return A;
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
