/**
 * @author liwei
 */
public class NumArray4 {

    private int[] nums;

    /**
     * 树状数组
     */
    private FenwickTree fenwickTree;

    public NumArray4(int[] nums) {
        int len = nums.length;
        this.nums = nums;
        fenwickTree = new FenwickTree(len);
        for (int i = 0; i < len; i++) {
            // 树状数组的索引从 1 开始计数
            fenwickTree.update(i + 1, nums[i]);
        }
    }

    public void update(int i, int val) {
        // 树状数组的索引从 1 开始计数
        // 树状数组更新操作的第 2 个参数的含义是：更新值，即变化后的值（val） - 原来的值（nums[i]）
        fenwickTree.update(i + 1, val - nums[i]);
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        return fenwickTree.query(j + 1) - fenwickTree.query(i);
    }

    private class FenwickTree {

        /**
         * 预处理数组
         */
        private int[] sums_;
        private int len;

        public FenwickTree(int n) {
            this.len = n;
            sums_ = new int[n + 1];
        }

        /**
         * 单点更新
         *
         * @param i     原始数组索引 i
         * @param delta 变化值 = 更新以后的值 - 原始值
         */
        public void update(int i, int delta) {
            // 从下到上更新，注意，预处理数组，比原始数组的 len 大 1，故 预处理索引的最大值为 len
            while (i <= len) {
                sums_[i] += delta;
                i += lowbit(i);
            }
        }

        /**
         * 查询前缀和
         *
         * @param i 前缀的最大索引，即查询区间 [0, i] 的所有元素之和
         */
        public int query(int i) {
            // 从右到左查询
            int sum = 0;
            while (i > 0) {
                sum += sums_[i];
                i -= lowbit(i);
            }
            return sum;
        }

        public int lowbit(int x) {
            return x & (-x);
        }
    }
}
