import java.util.Arrays;
import java.util.Random;

public class LC384 {
    //Shuffle an Array
    //新建一个数组,每次都生成新的数,生成的数只能和之前已经存在数进行swap
    public class Solution {

        private int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int[] reset() {
            return nums;
        }

        public int[] shuffle() {
            int[] rand = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                int r = new Random().nextInt(i + 1);
                rand[i] = rand[r];
                rand[r] = nums[i];
            }
            return rand;
        }
    }
}
