public class InsertSortData {

    public int sortedIndex = 0; // 当前已经排好序的部分的最后一个元素的索引
    public int currentIndex = -1; // 当前正在比较的元素的索引


    // 待排序的数组
    private int[] numbers;
    // 在构造函数中，使用随机数来生成待排序的数组

    /**
     * @param N           待排序数组的元素个数
     * @param randomBound 待排序数组的最大值
     */
    public InsertSortData(int N, int randomBound) {
        this.numbers = new int[N];
        for (int i = 0; i < N; i++) {
            // 为了避免出现 0 和负数，这样就失去了可视化的意义
            this.numbers[i] = (int) (Math.random() * randomBound) + 1;
        }
    }

    /**
     * 返回待排序数组的元素个数
     *
     * @return
     */
    public int N() {
        return numbers.length;
    }

    /**
     * 获得待排序数组索引为 index 的元素的值
     *
     * @param index
     * @return
     */
    public int get(int index) {
        if (index < 0 || index >= numbers.length)
            throw new IllegalArgumentException("Invalid index to access Sort Data.");
        return numbers[index];
    }

    public void swap(int i, int j) {
        if (i == j) {
            return;
        }
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
