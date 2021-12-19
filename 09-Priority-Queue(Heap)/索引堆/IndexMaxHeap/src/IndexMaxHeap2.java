public class IndexMaxHeap2 {

    // 加入了反向查找的索引堆（还没写）

    private int[] data;
    private int[] indexes;
    private int size;
    private int capacity;

    public IndexMaxHeap2(int capacity) {
        data = new int[capacity + 1];

        indexes = new int[capacity + 1];

        size = 0;
        this.capacity = capacity;
    }

    private void siftUp(int k) {
        int tempIndex = indexes[k];
        int tempValue = data[indexes[k]];
        while (k > 1) {
            if (data[indexes[k / 2]] < tempValue) {
                indexes[k] = indexes[k / 2];
                k /= 2;
            } else {
                break;
            }
        }
        indexes[k] = tempIndex;
    }

    private void siftDown(int k) {
        int tempIndex = indexes[k];
        int tempValue = data[indexes[k]];
        // 只要它有孩子，注意，这里的等于号是十分关键的
        while (2 * k <= size) {
            int j = 2 * k;
            if (j + 1 <= size && data[indexes[j + 1]] > data[indexes[j]]) {
                j++;
            }
            if (tempValue >= data[indexes[j]]) {
                break;
            }
            indexes[k] = indexes[j];
            k = j;
        }
        indexes[k] = tempIndex;
    }

    public int poll() {
        if (size == 0) {
            throw new IllegalArgumentException("堆为空。");
        }
        int ret = indexes[1];
        indexes[1] = indexes[size];
        size--;
        siftDown(1);
        return ret;
    }

    public void offer(int index, int item) {
        if (size + 1 > capacity) {
            throw new IllegalArgumentException("堆空间已满。");
        }

        // 转换成内部数组的索引
        index++;

        if (index < 1 || index > capacity || indexes[index] != 0) {
            throw new IllegalArgumentException("用户提供的 index 不合法。");
        }

        data[index] = item;
        indexes[index] = index;

        size++;
        // 考虑将它上移
        siftUp(size);
    }

    public void change(int i, int item) {
        i++;
        data[i] = item;
        // 找到 index[j] = i，j 表示 data[i] 在堆中的位置之后 siftUp(j)，再 siftDown(j)
        for (int j = 1; j <= size; j++) {
            if (indexes[j] == i) {
                // 找到了 j
                siftDown(j);
                siftUp(j);
                return;
            }
        }
    }
}