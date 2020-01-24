import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3 {

    private class UnionFind {

        public static final int SIZE = 1_0000_0000;
        private int[] parent;
        private double[] value;
        private boolean[] used;

        public UnionFind() {
            this.parent = new int[SIZE];
            value = new double[SIZE];
            used = new boolean[SIZE];

            for (int i = 0; i < SIZE; i++) {
                parent[i] = i;
            }

            Arrays.fill(value, 1.0);
            Arrays.fill(used, false);
        }

        public void union(int x, int y, double val) {
            if (!used[x] && !used[y]) {
                used[x] = true;
                used[y] = true;

                parent[x] = y;
                value[x] = val;
            }

            if (!used[x] && used[y]) {
                used[x] = true;

                parent[x] = y;
                this.value[x] = val;
            }

            if (used[x] && !used[y]) {
                used[y] = true;

                parent[y] = x;
                this.value[y] = 1.0 / val;
            }

            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }

            parent[rootX] = rootY;
            value[rootX] *= val * value[rootY];
        }

        public int find(int x) {
            if (!used[x]) {
                return -1;
            }

            // 只能使用完全压缩
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
                value[x] *= value[parent[x]];
            }
            return parent[x];
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        UnionFind unionFind = new UnionFind();

        int equationsLen = equations.size();
        for (int i = 0; i < equationsLen; i++) {
            List<String> equation = equations.get(i);
            unionFind.union(equation.get(0).hashCode(), equation.get(1).hashCode(), values[i]);
        }

        int len = queries.size();

        double[] res = new double[len];

        for (int i = 0; i < len; i++) {
            int X = queries.get(i).get(0).hashCode();
            int Y = queries.get(i).get(1).hashCode();

            int rootX = unionFind.find(X);
            int rootY = unionFind.find(Y);

            if (rootX == -1 || rootY == -1) {
                res[i] = -1.0;
                continue;
            }

            if (rootX != rootY) {
                res[i] = -1.0;
            } else {
                res[i] = unionFind.value[X] / unionFind.value[Y];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> item1 = new ArrayList<>();
        item1.add("a");
        item1.add("b");

        List<String> item2 = new ArrayList<>();
        item2.add("b");
        item2.add("c");

        equations.add(item1);
        equations.add(item2);

        double[] values = new double[]{2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();

        List<String> query1 = new ArrayList<>();
        query1.add("a");
        query1.add("c");

        List<String> query2 = new ArrayList<>();
        query2.add("b");
        query2.add("a");

        List<String> query3 = new ArrayList<>();
        query3.add("a");
        query3.add("e");

        List<String> query4 = new ArrayList<>();
        query4.add("a");
        query4.add("a");

        List<String> query5 = new ArrayList<>();
        query5.add("x");
        query5.add("x");

        queries.add(query1);
        queries.add(query2);
        queries.add(query3);
        queries.add(query4);
        queries.add(query5);

        Solution3 solution3 = new Solution3();
        double[] res = solution3.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(res));

    }
}
