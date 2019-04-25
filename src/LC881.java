import java.util.Arrays;

public class LC881 {
    //Boats to Save People
    //一艘船规定了只能坐 2 个人, sort一遍后尾部抽一个较大的值, 头部抽一个较小的值, 尾部的数必然先除去, 如果尾部+头部<=limit, 则绑定坐船
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res = 0, n = people.length, hi = n - 1, lo = 0;
        while (lo <= hi) {
            int diff = limit - people[hi];
            if (diff - people[lo] >= 0) {
                lo++;
            }
            hi--;
            res++;
        }
        return res;
    }
}
