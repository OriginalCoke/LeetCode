import java.util.ArrayList;
import java.util.List;

public class LC1431 {
    //1431. Kids With the Greatest Number of Candies
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy = candies[0];
        for (int candy : candies) {
            maxCandy = Math.max(maxCandy, candy);
        }
        List<Boolean> res = new ArrayList<>();
        for (int candy : candies) {
            if (candy + extraCandies >= maxCandy) res.add(true);
            else res.add(false);
        }
        return res;
    }
}
