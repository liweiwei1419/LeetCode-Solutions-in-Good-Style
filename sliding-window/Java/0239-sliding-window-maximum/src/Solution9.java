import java.util.Arrays;

/**
 * @author liwei
 * @date 2019/7/10 9:27 AM
 */
public class Solution9 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{};
        }

        // 初始化最大索引堆，其容量是滑动窗口的大小
        IndexMaxHeap indexMaxHeap = new IndexMaxHeap(k);

        // 首先先把前 k 个元素加进去
        for (int i = 0; i < k; i++) {
            indexMaxHeap.insert(i, nums[i]);
        }

        // 结果集
        int[] res = new int[len - k + 1];

        // 然后就是产生滑动窗口的过程，先输出最大值，
        // 而后把当前考虑的数插入到将要滑出的左边界的索引位置
        for (int i = k; i < len; i++) {
            res[i - k] = indexMaxHeap.peekMaxValue();
            indexMaxHeap.change(i % k, nums[i]);
        }
        // 因为最大索引堆更新了最后 1 个数，因此最后还要看一眼最大值
        res[len - k] = indexMaxHeap.peekMaxValue();
        return res;
    }


    class IndexMaxHeap {

        private int[] data;
        private int count;
        private int capacity;
        private int[] indexes;
        private int[] reverse;

        // 使用了反向查找技术的最大索引堆

        public IndexMaxHeap(int capacity) {
            data = new int[capacity + 1];
            indexes = new int[capacity + 1];
            reverse = new int[capacity + 1];
            count = 0;
            this.capacity = capacity;
        }


        public int getSize() {
            return count;
        }


        public boolean isEmpty() {
            return count == 0;
        }


        public void insert(int i, int item) {
            assert count + 1 <= capacity;
            assert i + 1 >= 1 && i + 1 <= capacity;
            i += 1;
            data[i] = item;

            indexes[count + 1] = i;
            reverse[i] = indexes[count + 1];

            count++;
            shiftUp(count);
        }


        private void shiftUp(int k) {
            while (k > 1 && data[indexes[k / 2]] < data[indexes[k]]) {

                swap(indexes, k / 2, k);
                // 注意分析这行代码，即使上一行 indexes 的两个元素交换了位置，但是并没有改变他们的值
                // 每一次交换了 indexes 索引以后，还要把 reverse 索引也交换
                swap(reverse, indexes[k / 2], indexes[k]);

                k /= 2;
            }
        }


        private void shiftUp1(int k) {
            while (k > 1 && data[indexes[k / 2]] < data[indexes[k]]) {
                swapIndexes(k / 2, k);
                k /= 2;
            }
        }


        private void swapIndexes(int index1, int index2) {
            if (index1 == index2) {
                return;
            }
            int temp = indexes[index1];
            indexes[index1] = indexes[index2];
            indexes[index2] = temp;

            reverse[indexes[index1]] = index2;
            reverse[indexes[index2]] = index1;
        }


        private void swap(int[] data, int index1, int index2) {
            if (index1 == index2) {
                return;
            }
            int temp = data[index1];
            data[index1] = data[index2];
            data[index2] = temp;
        }


        /**
         * @return
         */
        public int extractMax() {
            // 将此时二叉堆中的最大的那个数据删除（出队），返回的是数据，不是返回索引
            assert count > 0;
            int ret = data[indexes[1]];
            // 只要设计交换的操作，就一定是索引数组交换
            // 每一次交换了 indexes 索引以后，还要把 reverse 索引也交换
            swap(indexes, 1, count);
            swap(reverse, indexes[1], indexes[count]);
            count--;
            shiftDown(1);
            return ret;
        }


        /**
         * @return
         */
        public int extractMax1() {
            // 将此时二叉堆中的最大的那个数据删除（出队），返回的是数据，不是返回索引
            assert count > 0;
            int ret = data[indexes[1]];
            // 只要设计交换的操作，就一定是索引数组交换
            // 每一次交换了 indexes 索引以后，还要把 reverse 索引也交换
            swapIndexes(1, count);
            count--;
            shiftDown(1);
            return ret;
        }


        private void shiftDown(int k) {
            while (2 * k <= count) {
                int j = 2 * k;
                if (j + 1 <= count && data[indexes[j + 1]] > data[indexes[j]]) {
                    j = j + 1;
                }
                if (data[indexes[k]] >= data[indexes[j]]) {
                    break;
                }

                // 每一次交换了 indexes 索引以后，还要把 reverse 索引也交换
                swap(indexes, k, j);
                swap(reverse, indexes[k], indexes[j]);

                k = j;
            }
        }


        private void shiftDown1(int k) {
            while (2 * k <= count) {
                int j = 2 * k;
                if (j + 1 <= count && data[indexes[j + 1]] > data[indexes[j]]) {
                    j = j + 1;
                }
                if (data[indexes[k]] >= data[indexes[j]]) {
                    break;
                }
                // 每一次交换了 indexes 索引以后，还要把 reverse 索引也交换
                swapIndexes(k, j);
                k = j;
            }
        }


        public int extractMaxIndex() {
            assert count > 0;
            int ret = indexes[1] - 1;

            // 每一次交换了 indexes 索引以后，还要把 reverse 索引也交换
            swap(indexes, 1, count);
            swap(reverse, indexes[1], indexes[count]);

            count--;
            shiftDown(1);
            return ret;
        }


        public int extractMaxIndex1() {
            assert count > 0;
            int ret = indexes[1] - 1;
            // 每一次交换了 indexes 索引以后，还要把 reverse 索引也交换
            swapIndexes(1, count);
            count--;
            shiftDown(1);
            return ret;
        }


        public int getItem(int i) {
            return data[i + 1];
        }


        public void change(int i, int item) {
            i = i + 1;
            data[i] = item;

            // 原先遍历的操作，现在就变成了这一步，是不是很酷
            int j = reverse[i];
            shiftDown(j);
            shiftUp(j);
        }


        /**
         * 为 LeetCode 第 239 题新增的方法，
         * 看一眼此时索引堆的最大索引是多少（没用上，我想多了，留到以后用吧）
         *
         * @return
         */
        public int peekMaxIndex() {
            if (this.count == 0) {
                throw new RuntimeException("堆里没有可以取出的元素");
            }
            // 注意：与用户认为的索引值有一个偏差
            return indexes[1] - 1;
        }

        /**
         * 为 LeetCode 第 239 题新增的方法，
         * 看一眼此时索引堆的最大索引是多少（没用上，我想多了，留到以后用吧）
         *
         * @return
         */
        public int peekMaxValue() {
            if (this.count == 0) {
                throw new RuntimeException("堆里没有可以取出的元素");
            }
            // 注意：与用户认为的索引值有一个偏差
            return data[indexes[1]];
        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] res = solution2.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }
}
