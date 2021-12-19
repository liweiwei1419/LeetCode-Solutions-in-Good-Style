// 在堆的有关操作中，需要比较堆中元素的大小，所以 Item 需要 extends Comparable
// 刚开始写的时候可能不太习惯，多写几次就好了
// 不要犯懒，堆的操作其实并不复杂，一定要动手多写，达到白板编程都能熟练写出来的状态
public class MinHeap<Item extends Comparable> {
    private Item[] data;
    private int count;
    private int capacity;

    // 构造函数, 构造一个空堆, 可容纳 capacity 个元素
    public MinHeap(int capacity) {
        // 注意这种写法，不要 new Object，编译不能通过
        data = (Item[]) new Comparable[capacity + 1];
        this.capacity = capacity;
        this.count = 0;
    }

    // 通过给一个数组，创建一个最小堆
    public MinHeap(Item[] arr) {
        int n = arr.length;
        this.capacity = n;
        data = (Item[]) new Comparable[n + 1];
        for (int i = 0; i < n; i++) {
            data[i + 1] = arr[i];
        }
        this.count = n;
        for (int i = count / 2; i >= 1; i++) {
            shiftDown(i);
        }
    }

    // 返回堆中的元素个数
    public int size() {
        return count;
    }

    // 返回堆中是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    // 向最小堆中插入一个新的元素 item
    public void insert(Item item) {
        assert count < capacity;
        count++;
        data[count] = item;
        shiftUp(count);
    }

    // 从最小堆中取出堆顶元素, 即堆中所存储的最小数据
    public Item extractMin() {
        assert count > 0;
        Item min = data[1];
        swap(data, 1, count);
        count--;
        shiftDown(1);
        return min;
    }

    // 获取最小堆中的堆顶元素
    public Item getMin() {
        assert (count > 0);
        return data[1];
    }


    private void shiftUp(int k) {
        while (k > 1 && data[k / 2].compareTo(data[k]) > 0) {
            swap(data, k / 2, k);
            k = k / 2;
        }
    }

    private void shiftDown(int k) {
        while (2 * k <= count) {// 只要有左孩子，就应该考虑是否可以 shiftDown
            int t = 2 * k;
            if (t + 1 < count && data[t].compareTo(data[t + 1]) > 0) {
                t++;
            }
            if (data[t].compareTo(data[k]) > 0) {
                // 两个孩子中最小的那个元素都比父亲大，就满足最小堆的性质，循环退出
                break;
            }
            swap(data, t, k);
            k = t;
        }
    }

    private void swap(Item[] arr, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        Item temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    public static void main(String[] args) {
        MinHeap<Integer> minHeap = new MinHeap<>(10);

        minHeap.insert(9);
        minHeap.insert(8);
        minHeap.insert(7);

        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.extractMin());
    }
}