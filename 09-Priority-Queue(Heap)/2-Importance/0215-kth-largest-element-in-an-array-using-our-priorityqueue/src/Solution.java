import java.util.Comparator;

public class Solution {

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        // 这里为了使用 heapify 方法，赋值了一个新数组到优先队列中
        Integer[] copy = new Integer[k];
        for (int i = 0; i < k; i++) {
            copy[i] = nums[i];
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(copy, Comparator.comparingInt(a -> a));
        for (int i = k; i < len; i++) {
            Integer topElement = minHeap.peek();
            if (nums[i] > topElement) {
                minHeap.replace(nums[i]);
            }
        }
        return minHeap.peek();
    }

    public class PriorityQueue<T> {

        private T[] data;

        private Comparator<T> cmp;

        private int capacity;

        private int size;

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public T peek() {
            if (isEmpty()) {
                throw new IllegalArgumentException("堆为空。");
            }
            // 下标 0 不存元素
            return data[1];
        }

        public PriorityQueue(int capacity, Comparator<T> cmp) {
            this.cmp = cmp;
            data = (T[]) new Object[capacity + 1];
            this.capacity = capacity;
            size = 0;
        }

        public PriorityQueue(T[] arr, Comparator<T> cmp) {
            this.cmp = cmp;
            this.capacity = arr.length;
            this.data = (T[]) new Object[capacity + 1];
            for (int i = 0; i < arr.length; i++) {
                data[i + 1] = arr[i];
            }
            // 这个赋值很重要
            size = arr.length;
            for (int k = size / 2; k >= 1; k--) {
                siftDown(k);
            }
        }

        public void offer(T item) {
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

        private void swap(T[] data, int index1, int index2) {
            T temp = data[index1];
            data[index1] = data[index2];
            data[index2] = temp;
        }

        private void siftUp(int k) {
            T temp = data[k];
            while (k > 1) {
                if (cmp.compare(data[k / 2], temp) > 0) {
                    data[k] = data[k / 2];
                    k /= 2;
                } else {
                    break;
                }
            }
            data[k] = temp;
        }

        public T poll() {
            if (size == 0) {
                throw new IllegalArgumentException("堆为空。");
            }
            T ret = data[1];
            // 把最后一个元素的值赋值到二叉堆的根结点
            data[1] = data[size];
            size--;
            siftDown(1);
            return ret;
        }

        private void siftDown(int k) {
            // 编写方式等价于「插入排序」的优化，先暂存，再逐个移动，最后空出位置把先前暂存元素放进去
            T temp = data[k];
            while (2 * k <= size) {
                int j = 2 * k;
                if (j + 1 <= size && cmp.compare(data[j + 1], data[j]) < 0) {
                    j++;
                }
                if (cmp.compare(temp, data[j]) <= 0) {
                    break;
                }
                data[k] = data[j];
                k = j;
            }
            data[k] = temp;
        }

        public void replace(T item) {
            if (isEmpty()) {
                throw new IllegalArgumentException("堆为空。");
            }
            // 注意：堆顶元素替换，size 不变
            data[1] = item;
            siftDown(1);
        }
    }
}