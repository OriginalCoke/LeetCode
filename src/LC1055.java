public class LC1055 {
    //Shortest Way to Form String
    //greedy
    public int shortestWay(String source, String target) {
        for (char c : target.toCharArray()) {
            if (!source.contains(String.valueOf(c))) return -1;
        }
        int res = 1, index = -1, prev = index + 1, n = target.length(), i = 0;
        while (i < n) {
            char c = target.charAt(i);
            index = source.indexOf(c, prev);
            prev = index + 1;
            if (index < 0) {
                res++;
            } else i++;
        }
        return res;
    }
}
