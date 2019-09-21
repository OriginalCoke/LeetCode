import java.util.Arrays;

public class LC1196 {
    //How Many Apples Can You Put into the Basket
    //greedy
    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int count = 0, currWeight = 0;
        for (int i = 0; i < arr.length; i++) {
            currWeight += arr[i];
            if (currWeight <= 5000) count++;
            else break;
        }
        return count;
    }
}
