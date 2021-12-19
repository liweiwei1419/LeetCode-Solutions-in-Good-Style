public class Solution {

    public int numSimilarGroups(String[] strs) {
        int len = strs.length;

        UnionFind unionFind = new UnionFind(len);
        // 如果单词不多，成对检查相似性: O(len^2 wordLen)
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                if (isSimilar(strs[i], strs[j])) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.getCount();
    }

    public boolean isSimilar(String word1, String word2) {
        int diff = 0;
        int len = word1.length();
        char[] charArray1 = word1.toCharArray();
        char[] charArray2 = word2.toCharArray();
        for (int i = 0; i < len; ++i) {
            if (charArray1[i] != charArray2[i]) {
                diff++;
            }
        }
        return diff <= 2;
    }

    private void swap(char[] charArray, int index1, int index2) {
        char temp = charArray[index1];
        charArray[index1] = charArray[index2];
        charArray[index2] = temp;
    }

    private class UnionFind {

        private int[] parent;

        private int count;

        public int getCount() {
            return count;
        }

        public UnionFind(int n) {
            this.parent = new int[n];
            this.count = n;
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
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
    }
}