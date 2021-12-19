public class LeetCode0215 {

    private class MinHeap {

        private int[] data;

        private int size;

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int peek() {
            if (isEmpty()) {
                throw new IllegalArgumentException("堆空间为空。");
            }
            return data[1];
        }

        private int capacity;

        public MinHeap(int capacity) {
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
            while (2 * k <= size) {
                int j = 2 * k;
                if (j + 1 <= size && data[j + 1] < data[j]) {
                    j = j + 1;
                }
                if (temp <= data[j]) {
                    break;
                }
                // 否则，交换位置，继续循环
                data[k] = data[j];
                k = j;
            }
            data[k] = temp;
        }

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

        public void replace(int item) {
            if (isEmpty()) {
                throw new IllegalArgumentException("堆为空。");
            }
            data[1] = item;
            siftDown(1);
        }

        private void swap(int[] data, int index1, int index2) {
            int temp = data[index1];
            data[index1] = data[index2];
            data[index2] = temp;
        }

    }

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        // 使用一个含有 k 个元素的最小堆
        MinHeap minHeap = new MinHeap(k);
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }
        for (int i = k; i < len; i++) {
            // 看一眼，不拿出，因为有可能没有必要替换
            int topElement = minHeap.peek();
            // 只要当前遍历的元素比堆顶元素大，堆顶弹出，遍历的元素进去
            if (nums[i] > topElement) {
                // Java 没有 replace，所以得先 poll 出来，然后再放回去
                minHeap.replace(nums[i]);
            }
        }
        return minHeap.peek();
    }
}
