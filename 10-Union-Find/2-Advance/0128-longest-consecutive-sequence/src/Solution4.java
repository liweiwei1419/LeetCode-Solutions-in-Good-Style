import java.util.HashMap;
import java.util.Map;

public class Solution4 {

    // 方法四：并查集：
    // 时间复杂度：平均意义下 O(N)
    // 空间复杂度：O(N)

    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
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

    /**
     * 由于数值是离散的，parent 数组使用哈希表代替
     */
    private class UnionFind {

        private Map<Integer, Integer> parent;
        // 维护以当前结点为根的子树的结点总数
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

        /**
         * union 方法返回了以合并以后的连通分量的结点个数
         *
         * @param x
         * @param y
         * @return
         */
        public int union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return 0;
            }

            int sizeX = size.get(rootX);
            int sizeY = size.get(rootY);

            int sum = sizeX + sizeY;
            if (sizeX < sizeY) {
                parent.put(rootX, rootY);
                size.put(rootY, sum);
            } else {
                parent.put(rootY, rootX);
                size.put(rootX, sum);
            }
            return sum;
        }

        public int find(int x) {
            while (x != parent.get(x)) {
                // 实现了路径压缩，底下那些结点错了没有关系，根结点对就可以了
                parent.put(x, parent.get(parent.get(x)));
                x = parent.get(x);
            }
            return x;
        }

        /**
         * 新增 contains 方法
         *
         * @param x
         * @return
         */
        public boolean contains(int x) {
            return parent.containsKey(x);
        }
    }
}