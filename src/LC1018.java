import java.util.*;

public class LC1018 {
    //Binary Prefix Divisible By 5
    //每次多一个最后一位,即数组的下标多一位,和为前者*2+多出的后一位
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int v = 0;
        for (int a : A) {
            v = v * 2 + a;
            v %= 5;
            res.add(v == 0);
        }
        return res;
    }
}
