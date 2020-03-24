import java.util.HashMap;
import java.util.Map;

public class Solution {

    private class UnionFind {
        private Map<Integer, Integer> parent;
        private Map<Integer, Integer> size;

        public UnionFind(int[] nums) {
            int len = nums.length;
            parent = new HashMap<>(len);
            size = new HashMap<>(len);

            for (int num : nums) {
                parent.put(num, num);
                size.put(num, 1);
            }
        }

        public int union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return 0;
            }
            parent.put(rootX, rootY);
            int sum = size.get(rootX) + size.get(rootY);
            size.put(rootY, sum);
            return sum;
        }

        /**
         * 实现了路径压缩
         *
         * @param x
         * @return
         */
        public int find(int x) {
            while (x != parent.get(x)) {
                parent.put(x, parent.get(parent.get(x)));
                x = parent.get(x);
            }
            return x;
        }

        public boolean contains(int x) {
            return parent.containsKey(x);
        }
    }

    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        UnionFind unionFind = new UnionFind(nums);

        int res = 1;

        for (int num : nums) {
            if (unionFind.contains(num - 1)) {
                res = Math.max(res, unionFind.union(num, num - 1));
            }

            if (unionFind.contains(num + 1)) {
                res = Math.max(res, unionFind.union(num, num + 1));
            }
        }
        return res;
    }
}
