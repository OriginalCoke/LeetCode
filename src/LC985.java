public class LC985 {
    //Sum of Even Numbers After Queries
//    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
//        int n = queries.length;
//        int[] res = new int[n];
//        for (int i = 0; i < n; i++) {
//            int val = queries[i][0], index = queries[i][1];
//            A[index] += val;
//            res[i] = helper(A);
//        }
//        return res;
//    }
//
//    int helper(int[] A) {
//        int sum = 0;
//        for (int a : A) {
//            if (a % 2 == 0) sum += a;
//        }
//        return sum;
//    }
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int n = queries.length, sum = 0;
        int[] res = new int[n];
        for (int a : A) {
            if (a % 2 == 0) sum += a;
        }
        for (int i = 0; i < n; i++) {
            int val = queries[i][0], index = queries[i][1];
            if (val % 2 == 0) {
                if (A[index] % 2 == 0) sum += val;
            } else {
                if (A[index] % 2 == 0) sum -= A[index];
                else sum += A[index] + val;
            }
            A[index] += val;
            res[i] = sum;
        }
        return res;
    }
}
