public class LC990 {
    //Satisfiability of Equality Equations
    //Union Find
    int[] parents;

    public boolean equationsPossible(String[] equations) {
        parents = new int[26];
        for (int i = 0; i < 26; i++) parents[i] = i;
        for (String equation : equations) {
            if (equation.charAt(1) == '=') union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int g1 = find(equation.charAt(0) - 'a');
                int g2 = find(equation.charAt(3) - 'a');
                if (g1 == g2) return false;
            }
        }
        return true;
    }

    public int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return find(parents[x]);
    }

    public void union(int a, int b) {
        int groupA = find(a);
        int groupB = find(b);
        if (groupA != groupB) {
            parents[groupA] = groupB;
        }
    }
}
