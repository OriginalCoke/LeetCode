import java.util.ArrayList;
import java.util.List;

public class LC763 {
    //Partition Labels
    //起初的想法:从开头遍历,每一个找到最后的出现位置,比较interval的端点
    //只记录最后的位置,给2个指针,一个记录当前的最大值,如果遍历后内部的所有值都小于最大值,则可以分区; 另一个指针记录分区的位置
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int[] lastIndex = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastIndex[S.charAt(i) - 'a'] = i;
        }
        int currMax = 0, prevLen = 0;
        for (int i = 0; i < S.length(); i++) {
            currMax = Math.max(currMax, lastIndex[S.charAt(i) - 'a']);
            //如果指针已经来到末尾
            if (i == currMax) {
                res.add(i - prevLen + 1);
                prevLen = i + 1;
            }
        }
        return res;
        //TC: O(N)     SC:  O(N)
    }
}
