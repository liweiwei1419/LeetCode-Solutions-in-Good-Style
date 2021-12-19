import java.util.Arrays;

/**
 * 使用了泛型的最大索引堆，
 * 在 change() 这个方法里使用了反向查找技术
 */
public class IndexMaxHeap1<T extends Comparable> {
    /**
     * 最大索引堆中的数据
     */
    private T[] data;

    private int[] indexes;
    private int[] reverse;

    private int count;
    private int capacity;


    /**
     * 底层数据数组、索引数组、反向查找数组从 1 号索引开始使用
     *
     * @param capacity
     */
    public IndexMaxHeap1(int capacity) {
        data = (T[]) new Comparable[capacity + 1];
        indexes = new int[capacity + 1];
        reverse = new int[capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            reverse[i] = 0;
        }
        count = 0;
        this.capacity = capacity;
    }


    public int size() {
        return count;
    }


    public boolean isEmpty() {
        return count == 0;
    }


    /**
     *
     *
     * @param i
     * @param t
     */
    public void insert(int i, T t) {
        assert count + 1 <= capacity;
        assert i >= 1 && i <= capacity - 1;
        i++;
        data[i] = t;

        // 索引数组和反向查找数组得同步更新
        indexes[count + 1] = i;
        reverse[i] = count + 1;

        count++;
        siftUp(count);
    }


    private void siftUp(int h) {
        while (h > 1) {
            if (data[indexes[h / 2]].compareTo(data[indexes[h]]) < 0) {
                // 索引数组交换的同时，反向查找数组也要同时交换
                swapIndexes(indexes, h / 2, h);
                h /= 2;
            } else {
                break;
            }
        }
    }


    private void swapIndexes(int[] indexes, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = temp;

        reverse[indexes[i]] = i;
        reverse[indexes[j]] = j;
    }


    public int extractMaxIndex() {
        assert count > 0;
        int ret = indexes[1] - 1;
        swapIndexes(indexes, 1, count);
        reverse[indexes[count]] = 0;
        count--;
        siftDown(1);
        return ret;

    }


    /**
     * @param h
     */
    private void siftDown(int h) {
        while (2 * h <= count) {
            int k = 2 * h;
            if (k + 1 <= count && data[indexes[k + 1]].compareTo(data[indexes[k]]) > 0) {
                k = k + 1;
            }
            if (data[indexes[h]].compareTo(data[indexes[k]]) < 0) {
                swapIndexes(indexes, h, k);
                h = k;
            } else {
                break;
            }
        }
    }


    /**
     * 获取最大索引堆中索引为 i 的元素
     *
     * @param i
     * @return
     */
    public T getItem(int i) {
        assert i + 1 >= 1 && i + 1 <= capacity;
        return data[i + 1];
    }


    /**
     * 将最大索引堆中索引为 i 的元素修改为 t
     *
     * @param i
     * @param t
     */
    public void change(int i, T t) {
        assert contain(i);

        i++;
        data[i] = t;
        // 找到 index[j] = i 中的 j，尝试将 j shiftUp 和 shiftDown
        // 使用了反向查找技术，就不用遍历索引数组了
        /*for(int j=1;i<=count;j++){
            if(indexes[j] == i){
                shiftDown(j);
                shiftUp(j);
                return;
            }
        }*/

        // 使用 reverse[] 数组以后，我们可以很方便地索引
        // 原来的数组索引为 i 的元素在 indexes 数组中的位置
        siftDown(reverse[i]);
        siftUp(reverse[i]);
    }


    /**
     * 在用户看来的索引 i 还在不在最大堆中
     * 看索引i所在的位置是否存在元素
     *
     * @param i
     * @return
     */
    private boolean contain(int i) {
        assert i >= 0 && i + 1 <= capacity;
        return reverse[i + 1] == 0;
    }


    /**
     * 测试最大索引堆的方法
     */
    public boolean testIndex() {
        int[] copyIndex = new int[count + 1];
        int[] copyReverse = new int[count + 1];

        for (int i = 0; i <= count; i++) {
            copyIndex[i] = indexes[i];
        }

        for (int i = 0; i <= count; i++) {
            copyReverse[i] = reverse[i];
        }

        System.out.println("数据堆" + Arrays.toString(data));
        System.out.println("索引堆" + Arrays.toString(copyIndex));
        System.out.println("反向索引堆" + Arrays.toString(copyIndex));
        Arrays.sort(copyIndex);

        System.out.println("排序以后的索引堆" + Arrays.toString(copyIndex));

        boolean res = true;
        for (int i = 1; i <= count; i++) {
            if (copyIndex[i - 1] + 1 != copyIndex[i]) {
                res = false;
                break;
            }
        }

        if (!res) {
            System.out.println("error");
            return false;
        }
        return true;
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
    public T peekMaxValue() {
        if (this.count == 0) {
            throw new RuntimeException("堆里没有可以取出的元素");
        }
        return data[indexes[1]];
    }

    public void showIndexes() {
        System.out.printf("最大索引堆中的数据结构");
        System.out.println(Arrays.toString(data));
        System.out.printf("最大索引堆内部的索引堆的数据结构");
        System.out.println(Arrays.toString(indexes));
        System.out.printf("最大索引堆中反向索引堆中的数据结构");
        System.out.println(Arrays.toString(reverse));
    }


    /**
     * 测试 IndexMaxHeap4
     * @param args
     */
    public static void main(String[] args) {
        /*int N = 10;
        IndexMaxHeap1<Integer> indexMaxHeap = new IndexMaxHeap1<>(N);
        for (int i = 0; i < N; i++) {
            indexMaxHeap.insert(i, (int) (Math.random() * N));
        }
        indexMaxHeap.showIndexes();
        indexMaxHeap.testIndex();
        int[] arr = new int[N];
        while (!indexMaxHeap.isEmpty()) {
            int num = indexMaxHeap.getItem(indexMaxHeap.extractMaxIndex());
            //System.out.println(num);
            arr[--N] = num;
        }
        SortTestHelper.testSorted(arr);*/

        IndexMaxHeap1<Integer> indexMaxHeap = new IndexMaxHeap1<>(10);
        indexMaxHeap.insert(0, 15);
        indexMaxHeap.insert(1, 17);
        indexMaxHeap.insert(2, 19);
        indexMaxHeap.insert(3, 13);
        indexMaxHeap.insert(4, 22);
        indexMaxHeap.insert(5, 16);
        indexMaxHeap.insert(6, 28);
        indexMaxHeap.insert(7, 30);
        indexMaxHeap.insert(8, 41);
        indexMaxHeap.insert(9, 62);
        indexMaxHeap.showIndexes();
        while (!indexMaxHeap.isEmpty()) {
            int maxIndex = indexMaxHeap.extractMaxIndex();
            int element = indexMaxHeap.getItem(maxIndex);
            System.out.printf("%d,", element);
        }
    }
}
