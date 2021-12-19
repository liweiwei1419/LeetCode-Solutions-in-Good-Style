public class MaxHeap {
    /**
     * 我们这个版本的实现中，0 号索引是不存数据的，这一点一定要注意
     */
    private int[] data;

    /**
     * 当前堆中存储的元素的个数
     */
    private int count;

    /**
     * 堆中能够存储的元素的最大数量（为简化问题，不考虑动态扩展）
     */
    private int capacity;

    /**
     * 构造函数
     *
     * @param capacity
     */
    public MaxHeap(int capacity) {
        // 初始化最大堆
        // 初始化底层数组元素（ 0 号索引位置不存数据，这是为了使得通过父节点获得左右孩子有更好的表达式）
        data = new int[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }


    /**
     * 传递一个数组，形成一个最大堆，这一步操作叫 heapify
     * 从 index/2 这个元素开始，到 root 即 index = 1 的节点，依次进行 shift down 就可以构建成最大堆了
     *
     * @param arr
     */
    public MaxHeap(int[] arr) {
        int count = arr.length;
        data = new int[count + 1];
        for (int i = 1; i <= count; i++) {
            data[i] = arr[i - 1];
        }
        // 这一步很关键，并且位置也很关键，因为 shift down 依赖这个值，用 debug 就可以测试出来
        this.count = count;

        for (int k = count / 2; k >= 1; k--) {
            siftDown(k);
        }
    }


    /**
     * 返回堆中的元素个数
     * @return
     */
    public int getSize() {
        return count;
    }


    /**
     * 返回一个布尔值，表示堆中元素是否为空
     * @return
     */
    public boolean isEmpty() {
        return count == 0;
    }


    /**
     * 在堆的尾部增加一个元素，将这个元素执行 shift up 操作，保持最大堆的性质
     * 思路：在数组的最后位置添加一个元素，然后把这个元素 shift up 放在合适的位置
     *
     * @param item
     */
    public void insert(int item) {
        assert count + 1 <= capacity;
        // 把新添加的元素放在数组的最后一位，对应于最大堆最后一个叶子节点
        data[count + 1] = item;
        count++;
        // 考虑将它上移
        siftUp(count);
    }

    /**
     * 将索引是 k 这个位置（第 k 位，注意我们最大堆的根节点从数组索引为 1 的地方开始定义）的元素
     * 逐渐上移，直到满足最大堆的定义
     *
     * @param k
     */
    private void siftUp(int k) {
        int temp = data[k];
        // 有索引就要考虑索引越界的情况，已经在索引 1 的位置，就没有必要上移了
        while (k > 1 && data[k / 2] < temp) {
            data[k] = data[k / 2];
            k /= 2;
        }
        data[k] = temp;
    }


    /**
     * 对索引是 h 的元素执行 shiftUp 操作
     *
     * @param h
     */
    private void siftUp1(int h) {
        int temp = data[h];
        while (h > 1) {
            if (data[h / 2] < temp) {
                data[h] = data[h / 2];
                h /= 2;
            } else {
                break;
            }
        }
        data[h] = temp;
    }


    /**
     * shiftUp 的简单实现：逐层交换上移
     *
     * @param k
     */
    private void siftUp_(int k) {
        // 有索引就要考虑索引越界的情况，已经在索引 1 的位置，就没有必要上移了
        while (k > 1 && data[k / 2] < data[k]) {
            swap(data, k / 2, k);
            k /= 2;
        }
    }


    /**
     * 把指定索引（记住：这里的索引从 1 开始）的元素与父节点进行比较，如果父节点大，就要进行交换
     *
     * @param count
     */
    private void siftUp__(int count) {
        // 父节点的索引
        for (int k = count; k >= 1 && data[k] > data[k / 2]; k /= 2) {
            swap(data, k, k / 2);
        }
    }


    private void swap(int[] data, int index1, int index2) {
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }


    /**
     * 取出最大堆中的根节点
     * 1、把最后一个元素和索引是 1 的元素进行交换
     * 2、从根节点开始逐层下移：下移的过程中将与左右孩子节点进行比较，把最大的那个跟自己交换
     *
     * @return 根节点的元素
     */
    public int extractMax() {
        assert count > 0;
        int ret = data[1];
        // 把最后一个元素和第 1 个元素交换
        swap(data, 1, count);
        count--;
        siftDown(1);
        return ret;
    }


    /**
     * 把在索引 k 这个位置元素逐渐下移
     *
     * @param k
     */
    private void siftDown(int k) {
        int temp = data[k];
        // 只要它有孩子，注意，这里的等于号是十分关键的
        while (2 * k <= count) {
            int j = 2 * k;
            // 如果它有右边的孩子，并且右边的孩子大于左边的孩子
            if (j + 1 <= count && data[j + 1] > data[j]) {
                // 右边的孩子胜出，此时可以认为没有左孩子，
                j = j + 1;
            }
            // 如果当前的元素的值，比右边的孩子节点要大，则逐渐下落的过程到此结束
            if (temp >= data[j]) {
                break;
            }
            // 否则，交换位置，继续循环
            data[k] = data[j];
            k = j;
        }
        data[k] = temp;
    }


    /**
     * 把在索引 k 这个位置元素逐渐下落
     *
     * @param k
     */
    private void siftDown_(int k) {
        // 只要它有孩子，注意，这里的等于号是十分关键的
        while (2 * k <= count) {
            int j = 2 * k;
            // 如果它有右边的孩子，并且右边的孩子大于左边的孩子
            if (j + 1 <= count && data[j + 1] > data[j]) {
                // 右边的孩子胜出，此时可以认为没有左孩子，
                j = j + 1;
            }
            // 如果当前的元素的值，比右边的孩子节点要大，则逐渐下落的过程到此结束
            if (data[k] >= data[j]) {
                break;
            }
            // 否则，交换位置，继续循环
            swap(data, k, j);
            k = j;
        }
    }


    /**
     * 打印出这个最大堆
     */
    public void showMaxHeap() {
        for (int i = 1; i <= count; i++) {
            System.out.printf("%d ", data[i]);
        }
        System.out.println();
    }


    /**
     * 显示最大堆中的数据
     */
    public void show() {
        System.out.printf("[");
        for (int i = 1; i <= count; i++) {
            if (i == count) {
                System.out.printf("%d]\n", data[i]);
            } else {
                System.out.printf("%d,", data[i]);
            }
        }
    }


    /**
     * 判断自己写的数据结构是否符合最大堆的定义
     */
    public void judgeMaxHeapDefinition() {

        boolean flag = false;
        for (int k = 1; 2 * k <= count || 2 * k + 1 <= count; k++) {
            if (2 * k <= count) {
                if (data[2 * k] >= data[k]) {
                    flag = true;
                    break;
                }
            }

            if (2 * k + 1 <= count) {
                if (data[2 * k + 1] >= data[k]) {
                    flag = true;
                    break;
                }
            }

        }
        if (flag) {
            throw new RuntimeException("不符合最大堆的定义");
        }
        System.out.println("符合最大堆的定义");
    }


    public void heapSort(int[] nums) {
        int[] temp = nums.clone();
        for (Integer item : temp) {
            insert(item);
        }
        while (count > 0) {
            nums[count - 1] = extractMax();
        }
    }
}
