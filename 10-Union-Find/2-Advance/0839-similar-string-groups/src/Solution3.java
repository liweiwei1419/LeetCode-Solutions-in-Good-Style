public class Solution3 {

    public int numSimilarGroups(String[] strs) {
        // 一共有多少个单词
        int n = strs.length;
        // 每个单词的长度
        int m = strs[0].length();

        UnionFind unionFind = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (unionFind.isConnected(i, j)) {
                    continue;
                }
                if (check(strs[i], strs[j], m)) {
                    unionFind.isConnected(i, j);
                }
            }
        }
        return unionFind.getCount();
    }

    private class UnionFind {

        private int[] parent;

        private int count;

        public int getCount() {
            return count;
        }

        public UnionFind(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            return parent[x] == x ? x : (parent[x] = find(parent[x]));
        }

        public boolean isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            return rootX == rootY;
        }

    }

    public boolean check(String a, String b, int len) {
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
                if (count > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}