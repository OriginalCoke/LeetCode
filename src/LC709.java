public class LC709 {
    //To Lower Case
    public static void main(String[] args) {
        String a = "Hello";
        System.out.println(toLowerCase(a));
    }

    public static String toLowerCase(String str) {
        char[] A = str.toCharArray();
        for (int i = 0; i < A.length; i++) {
            char temp = A[i];
            if (temp >= 'A' && temp <= 'Z') {
                A[i] = (char) ((int) temp + 32);
            }
        }
        return String.valueOf(A);
    }
}
