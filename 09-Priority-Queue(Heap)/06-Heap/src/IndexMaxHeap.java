// 索引最大堆的第 1 个版本的实现，引入 indexes 数组，通过 indexes 数组的整理，使得
// data[index[1]],data[index[2]],...,data[index[count]] 成为一个最大堆
// 注意：在这个版本的实现中，如果我们要找到使用者认为的 data 数组索引为 i 的那个元素，
// 我们要遍历 indexes 数组，看看从 0 到 count 中的 j，哪个使得 indexes[j] = i
// 在下一个版本中，我们会改进这个方法，通过维护一个 reverse 数组，使用 O(1) 复杂度，直接得到 j


import java.util.Arrays;

// 对于索引堆的使用者，他们只需要知道，这是一个数据结构，可以往里面存入数据，
// 而每一次那出来的数据，都是当前已经存放在这个数据结构中最大的那个元素。
// 理解这里的操作要牢牢抓住一点
// indexes 数组（映射以后）的形态形成一个堆
// 最典型的特征就是，indexes 数组的第 1 个存放位置的元素对应的 data 是最大的

public class IndexMaxHeap {

    /**
     * 最大索引堆中的数据，我们这个版本的实现中，0 号索引不存数据
     */
    private int[] data;
    /**
     * 当前最大索引堆中的元素个数
     */
    private int count;
    /**
     * 最大索引堆的容量，一经确定，就不能更改
     */
    private int capacity;

    /**
     * 最大索引堆中的内置索引，外部用户并不感知
     */
    private int[] indexes;

    /**
     * 初始化
     * @param capacity
     */
    public IndexMaxHeap(int capacity) {
        data = new int[capacity + 1];
        indexes = new int[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    /**
     * 返回堆中的元素个数
     * @return
     */
    public int getSize() {
        return count;
    }

    /**
     * 返回一个布尔值, 表示堆中是否为空
     * @return
     */
    public boolean isEmpty() {
        return count == 0;
    }

    // insert 是我们第一个要改造的方法，我们给这个方法加上一个位置索引
    // 【特别注意】待插入数据的索引的位置是不能存放数据的，或者说这里存放的数据已经失效
    // 【特别注意】待插入数据的索引的位置是不能存放数据的，或者说这里存放的数据已经失效
    // 【特别注意】待插入数据的索引的位置是不能存放数据的，或者说这里存放的数据已经失效

    // 比如：这个索引的位置可以是用户认为的数据的末尾，或者是刚刚出队的那个索引，注意，一定是不能有数据的索引
    // 比如：这个索引的位置可以是用户认为的数据的末尾，或者是刚刚出队的那个索引，注意，一定是不能有数据的索引
    // 比如：这个索引的位置可以是用户认为的数据的末尾，或者是刚刚出队的那个索引，注意，一定是不能有数据的索引

    // 例如，在他们的眼中，可以认为 0 号索引存放他们的第 1 个任务，1 号索引存放他们的第 2 个任务，而每一次出队的操作，我们都返回给他们优先级最高的那个任务

    /**
     * 插入，元素的索引是 i ，对于外部用户来说，i 是从 0 开始计算的
     *
     * @param i
     * @param item
     */
    public void insert(int i, int item) {
        // 注意：使用者认为的 i 总是比我们内部使用的 i 少 1

        // 检测1：确保可以添加
        assert count + 1 <= capacity;

        // 检测2：确保使用者给出的索引 i，经过转换（即 +1 ）以后落在 [1,...,capacity]，即是检测使用者传来的索引的合法性
        // 【特别注意】这里不要理解成数组的 insert i，要让 i 以及后面的元素后移，这不是这个方法要表达的意思
        // 这里的 i 应该保证：（1）还未添加数据；（2）这里存放的数据已经失效，一种应用场景是：刚刚出队的元素的索引，就可以作为这里的 insert 的 i
        assert i + 1 >= 1 && i + 1 <= capacity;
        // 0，1，2，3 一共 4
        // 转换成内部的索引
        i += 1;
        // 这个 data 在用户眼中认为的值
        data[i] = item;
        // 这一行代码要注意：indexes 数组一定是连续的
        // data[indexes[1]],data[indexes[2]],...,data[indexes[count]] 一定是构成堆的
        // 多看看这句话，indexes 数组的 [1,2,...,count] 是连续取值的
        // 而
        // 这一步很关键，在内部索引数组的最后设置索引数组的索引
        indexes[count + 1] = i;
        count++;
        siftUp(count);
    }


    /**
     * @param k
     */
    private void siftUp(int k) {
        // 注意：引入了索引以后，表示将索引数组的第 k 的位置的元素逐层上移
        // 注意：引入了索引以后，表示将索引数组的第 k 的位置的元素逐层上移
        // 注意：引入了索引以后，表示将索引数组的第 k 的位置的元素逐层上移

        // 代码编写要点：1、比较的时候使用 data
        // 2、交换的时候使用 indexes
        // 有索引就要考虑索引越界的情况
        while (k > 1 && data[indexes[k / 2]] < data[indexes[k]]) {
            swap(indexes, k / 2, k);
            k /= 2;
        }
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
        swap(indexes, 1, count);
        count--;
        siftDown(1);
        return ret;
    }


    /**
     * 把在索引 k 这个位置元素逐渐下落
     *
     * @param k
     */
    private void siftDown(int k) {
        // 只要它有孩子，注意，这里的等于号是十分关键的
        while (2 * k <= count) {
            int j = 2 * k;
            // 如果它有右边的孩子，并且右边的孩子大于左边的孩子
            if (j + 1 <= count && data[indexes[j + 1]] > data[indexes[j]]) {
                // 右边的孩子胜出，此时可以认为没有左孩子，
                j = j + 1;
            }
            // 如果当前的元素的值，比右边的孩子节点要大，则逐渐下落的过程到此结束
            if (data[indexes[k]] >= data[indexes[j]]) {
                break;
            }
            // 否则，交换位置，继续循环
            swap(indexes, k, j);
            k = j;
        }
    }


    // 以下是索引堆相比不是索引堆新增的一些操作

    /**
     * 这里应该理解为出队（删除），只不过返回的是当前二叉堆中最大元素的索引值
     * @return
     */
    public int extractMaxIndex() {
        // 将此时二叉堆中的最大元素的索引返回，注意，此时我们相当于让最大数据出栈（删除了元素）
        // 注意，执行一步这个操作以后，应该马上执行 getItem 获得数据
        // 否则，如果再执行一次 extractMaxIndex，得到的就不是原来那个索引值
        assert count > 0;
        // -1 是为了转换成用户的角度
        int ret = indexes[1] - 1;
        swap(indexes, 1, count);
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
        // 找到 index[j] = i，j 表示 data[i] 在堆中的位置
        // 之后 shiftUp(j)，在 shiftDown(j)
        for (int j = 1; j <= count; j++) {
            if (indexes[j] == i) {
                // 找到了 j
                siftDown(j);
                siftUp(j);
                return;
            }
        }
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


    // 编写测试用例
    public static void main(String[] args) {
        // 测试用例1
//        int[] nums = {2, 3, 3, 4, 2, 5, 2, 3, 3, 5};
//        IndexMaxHeap4 indexMaxHeap = new IndexMaxHeap4(nums.length);
//        for (int i = 0; i < nums.length; i++) {
//            indexMaxHeap.insert(i, nums[i]);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            System.out.print(indexMaxHeap.extractMax() + " ");
//            System.out.println("还剩多少元素：" + indexMaxHeap.count);
//        }


        // 测试用例2：

        int n = 30;

        int[] nums = SortTestHelper.generateRandomArray(n, 10, 100);
        System.out.println("原始数组：" + Arrays.toString(nums));

        IndexMaxHeap indexMaxHeap = new IndexMaxHeap(nums.length);

        for (int i = 0; i < n; i++) {
            indexMaxHeap.insert(i, nums[i]);
        }
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            int extractMax = indexMaxHeap.extractMax();
            // System.out.println("还剩多少元素：" + indexMaxHeap.count);
            ret[n - 1 - i] = extractMax;
        }


        System.out.println("我的排序：" + Arrays.toString(ret));
        int[] copy = nums.clone();
        Arrays.sort(copy);
        System.out.println("系统排序：" + Arrays.toString(copy));
        System.out.println("原始数组：" + Arrays.toString(nums));

        int N = 10000;
        IndexMaxHeap indexMapHeap = new IndexMaxHeap(N);
//        for (int i = 0; i < N; i++) {
//            int randomNum = (int) (Math.random() * N);
//            indexMapHeap.insert(i, randomNum);
//        }
//        int[] newArray = new int[N];
//        while (!indexMapHeap.isEmpty()) {
//            newArray[--N] = indexMapHeap.getItem(indexMapHeap.extractMapIndex());
//        }
//        SortTestHelper.testSorted(newArray);

        int[] data = new int[]{15, 17, 19, 13, 22, 16, 28, 30, 41, 62};
        for (int i = 0; i < data.length; i++) {
            indexMapHeap.insert(i, data[i]);
        }
        System.out.println(Arrays.toString(indexMapHeap.indexes));
    }
}
