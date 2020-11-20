import java.util.Arrays;

public class Solution3 {

    public int minIncrementForUnique(int[] A) {
        int len = A.length;
        if (len == 0) {
            return 0;
        }

        UnionFind unionFind = new UnionFind();
        int res = 0;
        for (int num : A) {
            if (unionFind.contains(num)) {
                int root = unionFind.find(num);
                int add = root + 1;
                res += (add - num);
                unionFind.init(add);
            } else {
                unionFind.init(num);
            }
        }
        return res;
    }

    private class UnionFind {
        /**
         * 代表元法，元素指向父亲结点
         */
        private int[] parent;

        public void init(int x) {
            // 初始化的时候，就得左边看一眼，右边看一眼
            parent[x] = x;
            if (x > 0 && parent[x - 1] != -1) {
                union(x, x - 1);
            }

            if (parent[x + 1] != -1) {
                union(x, x + 1);
            }
        }

        public boolean contains(int x) {
            return parent[x] != -1;
        }

        public UnionFind() {
            // 最坏情况下，题目给出的数值都是 40000，
            // 依次排下去，排到 79999
            this.parent = new int[79999];
            // 应初始化成为 -1，表示这个元素还没放进并查集
            Arrays.fill(parent, -1);
        }

        /**
         * 返回代表元结点
         *
         * @param x
         * @return 针对这道题，代表元选所有元素中最大的那个
         */
        public int find(int x) {
            while (x != parent[x]) {
                // 只要自己的父亲结点不是自己，就说明不是根结点，继续往上找 x = parent[x];
                // 这句是路径压缩，并查集的优化，不加也行
                // parent[x] = parent[parent[x]]; 把 x 的父结点指向父亲结点的父亲结点
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {

            int rootX = find(x);
            int rootY = find(y);

            // 注意：根据这个问题的特点
            // 只能把小的结点指向大的结点
            if (rootX < rootY) {
                parent[rootX] = rootY;
            }

            if (rootY < rootX) {
                parent[rootY] = rootX;
            }
        }
    }
}