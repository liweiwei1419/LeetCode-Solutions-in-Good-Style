import java.util.Arrays;

/**
 * 使用了反向查找技术，没有实现泛型
 */
public class IndexMaxHeap2 {

    private int[] data;
    private int count;
    private int capacity;
    private int[] indexes;
    private int[] reverse;


    public IndexMaxHeap2(int capacity) {
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
        int temp = indexes[index1];
        indexes[index1] = indexes[index2];
        indexes[index2] = temp;

        reverse[indexes[index1]] = index2;
        reverse[indexes[index2]] = index1;
    }


    private void swap(int[] data, int index1, int index2) {
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
        siftDown(1);
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
        siftDown(1);
        return ret;
    }


    private void siftDown(int k) {
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
        siftDown(1);
        return ret;
    }


    public int extractMaxIndex1() {
        assert count > 0;
        int ret = indexes[1] - 1;
        // 每一次交换了 indexes 索引以后，还要把 reverse 索引也交换
        swapIndexes(1, count);
        count--;
        siftDown(1);
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
        siftDown(j);
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
        return data[indexes[1]];
    }

    /**
     * 测试用例
     * @param args
     */
    public static void main(String[] args) {
        // 测试用例2：
        int n = 10;

        int[] nums = SortTestHelper.generateRandomArray(n, 10, 100);
        System.out.println("原始数组：" + Arrays.toString(nums));

        IndexMaxHeap2 indexMaxHeap2 = new IndexMaxHeap2(nums.length);

        for (int i = 0; i < n; i++) {
            indexMaxHeap2.insert(i, nums[i]);
        }
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            int extractMax = indexMaxHeap2.extractMax();
            // System.out.println("还剩多少元素：" + indexMaxHeap.count);
            ret[n - 1 - i] = extractMax;
        }

        System.out.println("我的排序：" + Arrays.toString(ret));
        int[] copy = nums.clone();
        Arrays.sort(copy);
        System.out.println("系统排序：" + Arrays.toString(copy));
        System.out.println("原始数组：" + Arrays.toString(nums));
    }
}
