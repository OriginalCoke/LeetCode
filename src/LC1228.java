public class LC1228 {
    //Missing Number In Arithmetic Progression
    //find the common difference
    public int missingNumber(int[] arr) {
        int diff = Math.min(Math.abs(arr[1] - arr[0]), Math.abs(arr[2] - arr[1]));
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = arr[i + 1] - arr[i];
            if (Math.abs(temp) != diff) {
                if (temp > 0) return arr[i] + diff;
                else return arr[i] - diff;
            }
        }
        return arr[0];
    }
}
