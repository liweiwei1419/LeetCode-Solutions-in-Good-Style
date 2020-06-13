import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3 {

    // 使用并查集，带权值的并查集

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();
        UnionFind unionFind = new UnionFind();

        for (int i = 0; i < equationsSize; i++) {
            String A = equations.get(i).get(0);
            String B = equations.get(i).get(1);
            double k = values[i];
            unionFind.union(A, B, k);
        }

        int len = queries.size();
        double[] res = new double[len];

        for (int i = 0; i < len; i++) {
            String X = queries.get(i).get(0);
            String Y = queries.get(i).get(1);


            if (!unionFind.parent.containsKey(X) || !unionFind.parent.containsKey(Y)) {
                res[i] = -1.0;
                continue;
            }

            Pair rootX = unionFind.find(X);
            Pair rootY = unionFind.find(Y);

            if (!rootX.father.equals(rootY.father)) {
                res[i] = -1.0;
            } else {
                res[i] = rootX.val / rootY.val;
            }
        }

        return res;
    }

    class Pair {
        private String father;
        private double val;

        public Pair(String father, double val) {
            this.father = father;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "var='" + father + '\'' +
                    ", quotient=" + val +
                    '}';
        }
    }

    class UnionFind {
        private Map<String, Pair> parent;

        public UnionFind() {
            parent = new HashMap<>();
        }

        /**
         * 返回根结点的 Pair 对象
         *
         * @param A
         * @return
         */
        private Pair find(String A) {
            double res = 1.0;
            String origin = A;
            while (!A.equals(parent.get(A).father)){
                res *= parent.get(A).val;
                A = parent.get(A).father;
            }

            parent.get(origin).father = A;
            parent.get(origin).val = res;
            return parent.get(origin);
        }

        private void union(String A, String B, double val) {
            if (!parent.containsKey(A) && !parent.containsKey(B)) {
                parent.put(A, new Pair(B, val));
                parent.put(B, new Pair(B, 1.0));
                return;
            }

            // 如果 A 是独立的，就把 A 指向 B
            if (!parent.containsKey(A)) {
                parent.put(A, new Pair(B, val));
                return;
            }

            // 如果 B 是独立的，就把 B 指向 A
            if (!parent.containsKey(B)) {
                parent.put(B, new Pair(A, 1.0 / val));
                return;
            }

            // 走到这里就是 A 和 B 在一个集合里的情况

            Pair rootA = find(A);
            Pair rootB = find(B);

            if (rootA != rootB) {
                rootA.father = rootB.father;
                rootA.val *= (val * rootB.val);
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

        Solution3 solution3 = new Solution3();
        double[] res = solution3.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(res));

    }
}
