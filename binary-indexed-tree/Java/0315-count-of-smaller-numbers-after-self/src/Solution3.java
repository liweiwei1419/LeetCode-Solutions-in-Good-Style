import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Solution3 {

    // 使用树状数组

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        // 特判
        int len = nums.length;
        if (len == 0) {
            return res;
        }

        // 使用二分搜索树方便排序
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // 排名表
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (Integer num : set) {
            map.put(num, rank);
            rank++;
        }

        FenwickTree fenwickTree = new FenwickTree(set.size() + 1);
        // 从后向前填表
        for (int i = len - 1; i >= 0; i--) {
            // 1、查询排名
            rank = map.get(nums[i]);
            // 2、在树状数组排名的那个位置 + 1
            fenwickTree.update(rank, 1);
            // 3、查询一下小于等于“当前排名 - 1”的元素有多少
            res.add(fenwickTree.query(rank - 1));
        }
        Collections.reverse(res);
        return res;
    }


    private class FenwickTree {
        private int[] tree;
        private int len;

        public FenwickTree(int n) {
            this.len = n;
            this.tree = new int[n + 1];
        }

        public FenwickTree(int[] nums) {
            this.len = nums.length;
            this.tree = new int[this.len + 1];
            for (int i = 0; i < this.len; i++) {
                update(i, nums[i]);
            }
        }

        /**
         * 单点更新：将 index 这个下标 + delta
         *
         * @param i
         * @param delta
         */
        public void update(int i, int delta) {
            // 从下到上，最多到 len，可以等于 len
            while (i <= this.len) {
                tree[i] += delta;
                i += lowbit(i);
            }
        }


        /**
         * 查询的语义是：查询前缀和 [1, i]，从下标 1 开始
         *
         * @param i
         * @return
         */
        public int query(int i) {
            // 从右到左查询
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= lowbit(i);
            }
            return sum;
        }

        private int lowbit(int x) {
            return x & (-x);
            // return x & (~x + 1);
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 6, 1};
        Solution2 solution4 = new Solution2();
        List<Integer> countSmaller = solution4.countSmaller(nums);
        System.out.println(countSmaller);
    }
}
