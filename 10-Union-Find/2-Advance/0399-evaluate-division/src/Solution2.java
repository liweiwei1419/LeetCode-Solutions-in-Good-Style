import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {

    // 原来的代码

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();
        // 最极端情况下，每一个等式的两边的变量都不同，因此并查集底层数组开 2 倍的 equations 的长度即可
        UnionFind unionFind = new UnionFind(2 * equationsSize);

        // 第 1 步：预处理，将变量的值与 id 进行映射，使得并查集的底层使用数组实现，方便编码
        Map<String, Integer> hashMap = new HashMap<>();
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

        // 第 2 步：做查询
        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            // 对每一个 query 查询变量对应的 id
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            Integer id1 = hashMap.get(var1);
            Integer id2 = hashMap.get(var2);
            // 两个变量只要其中一个不在以前出现过的变量集合中，返回 -1
            if (id1 == null || id2 == null) {
                res[i] = -1.0;
            } else {
                // 对并查集进行查询，如果在一个集合中，返回「权值商」
                // 如果不在一个集合中，返回 -1
                res[i] = unionFind.isConnected(id1, id2);
            }
        }
        return res;
    }


    private class UnionFind {

        private int[] parent;

        /**
         * 把父结点作为分母时的商（重点维护）
         */
        private double[] weight;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                // 单独一个结点的时候，自己除以自己，商为 1
                weight[i] = 1.0d;
            }
        }

        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            parent[rootX] = rootY;
            // 需要列方程计算
            weight[rootX] = weight[y] * value / weight[x];
        }

        public int find(int x) {
            // 这里只能使用完全压缩
            if (x != parent[x]) {
                // 注意：这里维护 weight 的定义，origin 表示在路径压缩之前 x 的父亲结点
                int origin = parent[x];
                parent[x] = find(parent[x]);
                // 先更新较浅层结点的权值，较深层结点的权值需要根据较浅层结点的权值进行更新
                weight[x] *= weight[origin]; // 这里要切换视频来讲
            }
            return parent[x];
        }

        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            // 注意：由于 find 执行了「完全压缩」的路径压缩优化，两个 find 执行完成以后
            // 如果 x 和 y 在同一个集合中，此时它们的父亲结点已经指向同一个根结点了
            if (rootX == rootY) {
                // 在一个集合中，返回权值商
                return weight[x] / weight[y];
            } else {
                // 不在一个集合中，返回 -1
                return -1.0d;
            }
        }
    }
}