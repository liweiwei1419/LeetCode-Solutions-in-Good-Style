import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Kruskal {

    /**
     * 最小生成树的权值之和
     */
    private int mstCost;

    public int getMstCost() {
        return mstCost;
    }

    /**
     * 最小生成树的边的列表
     */
    private List<int[]> mst;

    public List<int[]> getMst() {
        return mst;
    }

    /**
     * @param V
     * @param edges 每条边的定义：[起始点, 终点, 权值]
     */
    public Kruskal(int V, int[][] edges) {
        int E = edges.length;
        if (E < V - 1) {
            throw new IllegalArgumentException("参数错误");
        }
        mst = new ArrayList<>(E - 1);

        // 体现了贪心的思想，从权值最小的边开始考虑
        Arrays.sort(edges, Comparator.comparingInt(o -> o[2]));

        UnionFind unionFind = new UnionFind(V);
        // 当前找到了多少条边
        int count = 0;
        for (int[] edge : edges) {
            // 如果形成了环，就继续考虑下一条边
            if (unionFind.isConnected(edge[0], edge[1])) {
                continue;
            }

            unionFind.union(edge[0], edge[1]);

            this.mstCost += edge[2];
            mst.add(new int[]{edge[0], edge[1], edge[2]});
            count++;
            if (count == V - 1) {
                break;
            }
        }
    }

    private class UnionFind {

        private int[] parent;

        private int count;
        private int N;

        public UnionFind(int N) {
            this.N = N;
            this.count = N;
            this.parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }

            parent[rootX] = rootY;
            count--;
        }

        public int getCount() {
            return count;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }

    public static void main(String[] args) {
        int N = 7;
        int[][] edges = {{0, 1, 4},
                {0, 5, 8},
                {1, 2, 8},
                {1, 5, 11},
                {2, 3, 3},
                {2, 6, 2},
                {3, 4, 3},
                {4, 5, 8},
                {4, 6, 6},
                {5, 6, 7},
        };
        Kruskal kruskal = new Kruskal(N, edges);
        int mstCost = kruskal.getMstCost();
        System.out.println("最小生成树的权值之和：" + mstCost);
        List<int[]> mst = kruskal.getMst();
        System.out.println("最小生成树的边的列表：");
        for (int[] edge : mst) {
            System.out.println("[" + edge[0] + "-" + edge[1] + "]" + "，权值：" + edge[2]);
        }
    }
}
