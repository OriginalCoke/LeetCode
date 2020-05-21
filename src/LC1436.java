import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC1436 {
    //1436. Destination City
    public String destCity(List<List<String>> paths) {
        Set<String> possibleDes = new HashSet<>();
        for (List<String> path : paths) {
            possibleDes.add(path.get(1));
        }
        for (List<String> path : paths) {
            possibleDes.remove(path.get(0));
        }
        return possibleDes.iterator().next();
    }
}
