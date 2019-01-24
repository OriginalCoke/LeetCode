public class LC165 {
    //Compare Version Numbers
    //Google
    //split into list?

    public static void main(String[] args) {
        String version1 = "0.1";
        String version2 = "1.1";
        System.out.println(compareVersion(version1, version2));
    }

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int m = v1.length, n = v2.length, min = Math.min(m, n), max = Math.max(m, n);
        for (int i = 0; i < min; i++) {
            int t1 = Integer.parseInt(v1[i]);
            int t2 = Integer.parseInt(v2[i]);
            if (t1 > t2) return 1;
            else if (t1 < t2) return -1;
        }
        if (m >= n) {
            for (int i = min; i < max; i++) {
                int rest = Integer.parseInt(v1[i]);
                if (rest > 0) return 1;
            }
        } else {
            for (int i = min; i < max; i++) {
                int rest = Integer.parseInt(v2[i]);
                if (rest > 0) return -1;
            }
        }
        return 0;
    }
    //time : O(n)
}
