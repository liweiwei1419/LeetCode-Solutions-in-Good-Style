import java.util.Arrays;

public class MaxHeap implements Queue {

    /**
     * 本实现 0 号下标不存放真正数据，底层使用动态数组是更好地实现
     * 这里为了突出算法思想，只实现最基本功能，扩展留给读者
     */
    private int[] data;

    /**
     * 堆中能够存储的元素的最大数量
     */
    private int capacity;

    /**
     * 当前最大堆中真正存储的元素的个数
     */
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("堆为空。");
        }
        // 下标 0 不存元素
        return data[1];
    }

    public MaxHeap(int capacity) {
        data = new int[capacity + 1];
        this.capacity = capacity;
        size = 0;
    }

    public MaxHeap(int[] arr) {
        capacity = arr.length + 1;
        data = new int[capacity];
        size = arr.length;
        for (int i = 0; i < size; i++) {
            data[i + 1] = arr[i];
        }

        for (int i = size / 2; i >= 1; i++) {
            siftDown(i);
        }
    }

    @Override
    public void offer(int item) {
        if (size + 1 > capacity) {
            throw new IllegalArgumentException("堆空间已满。");
        }

        // 把新添加的元素放在数组的最后一位
        data[size + 1] = item;
        // 维护 size 的定义
        size++;
        // 考虑将 data[size] 元素上移到合适的位置
        siftUp(size);
    }

    private void siftUp(int k) {
        // 有下标就要考虑索引越界的情况，已经在下标 1 的位置，就没有必要上移了
        while (k > 1 && data[k / 2] < data[k]) {
            swap(data, k / 2, k);
            k /= 2;
        }
    }

    private void swap(int[] data, int index1, int index2) {
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    /**
     * 与 siftUp() 方法等价，siftUp 与 shiftUp 两种命名均可
     *
     * @param k
     */
    private void shiftUp(int k) {
        // 编写方式等价于「插入排序」的优化，先暂存，再逐个移动，最后空出位置把先前暂存元素放进去
        int temp = data[k];
        while (k > 1) {
            if (data[k / 2] < temp) {
                data[k] = data[k / 2];
                k /= 2;
            } else {
                break;
            }
        }
        data[k] = temp;
    }

    @Override
    public int poll() {
        if (size == 0) {
            throw new IllegalArgumentException("堆为空。");
        }
        int ret = data[1];
        // 把最后一个元素的值赋值到二叉堆的根结点
        data[1] = data[size];
        size--;
        siftDown(1);
        return ret;
    }


    private void siftDown(int k) {
        // 只要它有孩子，注意这里使用等于号，是因为真正存数据的下标从 1 开始
        while (2 * k <= size) {
            int j = 2 * k;
            // 如果它有右边的孩子，并且右边的孩子大于左边的孩子
            if (j + 1 <= size && data[j + 1] > data[j]) {
                // 右边的孩子胜出，此时可以认为没有左孩子，
                j++;
            }
            // 如果当前的元素的值，比右边的孩子节点要大，则逐渐下落的过程到此结束
            if (data[k] >= data[j]) {
                break;
            }
            // 否则，交换位置，继续上浮
            swap(data, k, j);
            k = j;
        }
    }


    /**
     * 与 siftDown() 方法等价，siftDown 与 shiftDown 两种命名均可
     *
     * @param k
     */
    private void shiftDown(int k) {
        // 编写方式等价于「插入排序」的优化，先暂存，再逐个移动，最后空出位置把先前暂存元素放进去
        int temp = data[k];
        while (2 * k <= size) {
            int j = 2 * k;
            if (j + 1 <= size && data[j + 1] > data[j]) {
                j++;
            }
            if (temp >= data[j]) {
                break;
            }
            data[k] = data[j];
            k = j;
        }
        data[k] = temp;
    }

    public void replace(int item) {
        if (isEmpty()) {
            throw new IllegalArgumentException("堆为空。");
        }
        // 注意：堆顶元素替换，size 不变
        data[1] = item;
        siftDown(1);
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);
        // int[] arr = {34, 35, 5, 42, 4, 76, 10, 39, 40, 41};
        int[] arr = {4, 76, 10, 39, 40, 41, 34, 35, 5, 42};

        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(maxHeap.data));
            maxHeap.offer(arr[i]);
        }
        System.out.println(Arrays.toString(maxHeap.data));
    }
}