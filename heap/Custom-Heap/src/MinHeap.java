import java.util.Random;

/**
 * @author liweiwei1419
 */
public class MinHeap implements Queue {

    /**
     * 为了计算左右子结点的索引方便，0 号索引不存放数据的
     */
    private int[] data;

    /**
     * 当前堆中存储的元素的个数
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
            throw new IllegalArgumentException("堆空间为空。");
        }
        return data[1];
    }


    /**
     * 堆中能够存储的元素的最大数量（为简化问题，不考虑动态扩展）
     */
    private int capacity;

    public MinHeap(int capacity) {
        // 初始化最大堆
        // 初始化底层数组元素（ 0 号索引位置不存数据，这是为了使得通过父节点获得左右孩子有更好的表达式）
        data = new int[capacity + 1];
        size = 0;
        this.capacity = capacity;
    }

    private void siftUp(int k) {
        int temp = data[k];
        while (k > 1) {
            if (data[k / 2] > temp) {
                data[k] = data[k / 2];
                k /= 2;
            } else {
                break;
            }
        }
        data[k] = temp;
    }

    /**
     * 在堆的尾部增加一个元素，将这个元素执行 sift up 操作，保持最大堆的性质
     * 思路：在数组的最后位置添加一个元素，然后把这个元素 sift up 放在合适的位置
     *
     * @param item
     */
    @Override
    public void offer(int item) {
        if (size + 1 > capacity) {
            throw new IllegalArgumentException("堆空间已满。");
        }

        // 把新添加的元素放在数组的最后一位，对应于最大堆最后一个叶子节点
        data[size + 1] = item;
        size++;
        // 考虑将它上移
        siftUp(size);
    }

    private void siftDown(int k) {
        int temp = data[k];
        // 只要它有孩子，注意，这里的等于号是十分关键的
        while (2 * k <= size) {
            int j = 2 * k;
            // 如果它有右边的孩子，并且右边的孩子大于左边的孩子
            if (j + 1 <= size && data[j + 1] < data[j]) {
                // 右边的孩子胜出，此时可以认为没有左孩子，
                j = j + 1;
            }
            // 如果当前的元素的值，比右边的孩子节点要大，则逐渐下落的过程到此结束
            if (temp <= data[j]) {
                break;
            }
            // 否则，交换位置，继续循环
            data[k] = data[j];
            k = j;
        }
        data[k] = temp;
    }

    /**
     * 取出最大堆中的根节点
     * 1、把最后一个元素和索引是 1 的元素进行交换
     * 2、从根节点开始逐层下移：下移的过程中将与左右孩子节点进行比较，把最大的那个跟自己交换
     *
     * @return 根节点的元素
     */
    @Override
    public int poll() {
        if (isEmpty()) {
            throw new IllegalArgumentException("堆为空。");
        }
        int ret = data[1];
        // 把最后一个元素和第 1 个元素交换
        swap(data, 1, size);
        size--;
        siftDown(1);
        return ret;
    }

    @Override
    public void replace(int item) {
        if (isEmpty()) {
            throw new IllegalArgumentException("堆为空。");
        }
        data[1] = item;
        siftDown(1);
    }

    private void heapify(int[] arr) {
        System.arraycopy(arr, 0, data, 1, size);

        for (int k = size / 2; k >= 1; k--) {
            siftDown(k);
        }
    }

    public MinHeap(int[] arr) {
        size = arr.length;
        capacity = size + 1;
        data = new int[capacity];

        heapify(arr);
    }

    private void swap(int[] data, int index1, int index2) {
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    // 测试方法
    public static void main(String[] args) {
        MinHeap maxHeap = new MinHeap(1000);
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            // 生成 [0, upBound) 之前的整数
            int randomInt = random.nextInt(100);
            maxHeap.offer(randomInt);
        }

        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());
        }
    }
}

