import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution6 {

    // 路径压缩没有做好

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();

        Map<String, Integer> hashMap = new HashMap<>();
        UnionFind unionFind = new UnionFind(2 * equationsSize);

        int id = 0;
        for (int i = 0; i < equationsSize; i++) {
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);

            if (!hashMap.containsKey(var1)) {
                hashMap.put(var1, id);
                id++;
            }

            if (!hashMap.containsKey(var2)) {
                hashMap.put(var2, id);
                id++;
            }
            unionFind.union(hashMap.get(var1), hashMap.get(var2), values[i]);
        }

//        System.out.println(hashMap);
//        System.out.println(Arrays.toString(unionFind.parent));
//        System.out.println(Arrays.toString(unionFind.weight));

        int queriesSize = queries.size();
        double[] res = new double[queriesSize];

        for (int i = 0; i < queriesSize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            Integer id1 = hashMap.get(var1);
            Integer id2 = hashMap.get(var2);

            if (id1 == null || id2 == null) {
                res[i] = -1.0;
            } else {
                res[i] = unionFind.isConnected(id1, id2);
            }
        }
        return res;
    }


    private class UnionFind {

        private int[] parent;
        private double[] weight;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);

            parent[rootX] = rootY;
            // 重点理解这句话
            weight[rootX] = weight[y] * value / weight[x];
        }

        public int find(int x) {
            double res = 1.0;
            int origin = x;
            while (x != parent[x]) {
                res = res * weight[x];
                x = parent[x];
            }
            parent[origin] = x;
            weight[origin] = res;
            return x;
        }

        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return weight[x] / weight[y];
            } else {
                return -1.0d;
            }

        }
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

        Solution6 solution6 = new Solution6();
        double[] res = solution6.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(res));
    }
}
