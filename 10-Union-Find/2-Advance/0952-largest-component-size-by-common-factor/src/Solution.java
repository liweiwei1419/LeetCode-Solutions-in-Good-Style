public class Solution {

    /**
     * 找到这个数所有的质数因子，然后把它们合并在一起
     *
     * @param A
     * @return
     */
    public int largestComponentSize(int[] A) {
        int maxVal = 1;
        for (int item : A) {
            maxVal = Math.max(maxVal, item);
        }

        UnionFind unionFind = new UnionFind(maxVal + 1);
        for (int num : A) {
            double upBound = Math.sqrt(num);
            // 注意 i <= upBound; 等于这里不要漏掉
            for (int i = 2; i <= upBound; i++) {
                if (num % i == 0) {
                    unionFind.union(num, i);
                    unionFind.union(num, num / i);
                }
            }
        }

        int res = 0;
        int[] cnt = new int[maxVal + 1];
        for (int value : A) {
            int root = unionFind.find(value);
            cnt[root]++;
            res = Math.max(res, cnt[root]);
        }
        return res;
    }


    /**
     * 用到了路径压缩，没有用到按 size 合并
     */
    private class UnionFind {

        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        /**
         * 实现了路径压缩，不是很完全的路径压缩
         *
         * @param x
         * @return
         */
        public int find(int x) {
//            while (x != parent[x]) {
//                parent[x] = parent[parent[x]];
//                x = parent[x];
//            }
//            return x;

            // 这一版路径压缩更彻底
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        /**
         * 没有实现按秩合并，因此谁指向谁都可以
         *
         * @param x
         * @param y
         */
        public void union(int x, int y) {
            parent[find(x)] = parent[find(y)];
        }
    }
}