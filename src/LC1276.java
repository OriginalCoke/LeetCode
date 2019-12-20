import java.util.ArrayList;
import java.util.List;

public class LC1276 {
    //Number of Burgers with No Waste of Ingredients
    //二元一次方程
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> res = new ArrayList<>();
        int a = tomatoSlices - 2 * cheeseSlices;
        int b = 4 * cheeseSlices - tomatoSlices;
        if (a < 0 || a % 2 == 1) return res;
        if (b < 0 || b % 2 == 1) return res;
        res.add(a / 2);
        res.add(b / 2);
        return res;
    }
}
