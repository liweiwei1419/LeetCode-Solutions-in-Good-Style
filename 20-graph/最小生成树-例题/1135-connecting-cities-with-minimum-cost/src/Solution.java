import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public int minimumCost(int N, int[][] connections) {
        int len = connections.length;
        if (len < N - 1) {
            return -1;
        }

        Arrays.sort(connections, Comparator.comparingInt(o -> o[2]));
        UnionFind unionFind = new UnionFind(N + 1);

        int mstCost = 0;
        int count = 0;
        for(int[] edge:connections){
            if (unionFind.isConnected(edge[0], edge[1])) {
                continue;
            }

            unionFind.union(edge[0], edge[1]);
            mstCost += edge[2];
            if (count == N - 1) {
                break;
            }
        }
        return mstCost;
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
        Solution solution = new Solution();
        int N = 3;
        int[][] conections = {{1, 2, 5}, {1, 3, 6}, {2, 3, 1}};
        int res = solution.minimumCost(N, conections);
        System.out.println(res);
    }
}
