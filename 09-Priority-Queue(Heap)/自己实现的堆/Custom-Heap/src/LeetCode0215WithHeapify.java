public class LeetCode0215WithHeapify {

    private class MaxHeap {

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

        public void replace(int item) {
            if (isEmpty()) {
                throw new IllegalArgumentException("堆为空。");
            }
            data[1] = item;
            siftUp(1);
        }

        private int capacity;

        public MaxHeap(int capacity) {
            data = new int[capacity + 1];
            size = 0;
            this.capacity = capacity;
        }

        private void heapify(int[] arr) {
            System.arraycopy(arr, 0, data, 1, size);

            // 自上而下，复杂度为 O(N \logN)
            for (int i = 2; i <= size; i++) {
                siftUp(i);
            }
        }

        public MaxHeap(int[] arr) {
            size = arr.length;
            capacity = size + 1;
            data = new int[capacity];

            heapify(arr);
        }

        private void siftUp(int k) {
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

        public void offer(int item) {
            if (size + 1 > capacity) {
                throw new IllegalArgumentException("堆空间已满。");
            }

            data[size + 1] = item;
            size++;
            siftUp(size);
        }

        private void siftDown(int k) {
            int temp = data[k];
            while (2 * k <= size) {
                int j = 2 * k;
                if (j + 1 <= size && data[j + 1] > data[j]) {
                    j = j + 1;
                }
                if (temp >= data[j]) {
                    break;
                }
                data[k] = data[j];
                k = j;
            }
            data[k] = temp;
        }

        public int poll() {
            if (size == 0) {
                throw new IllegalArgumentException("堆为空。");
            }
            int ret = data[1];
            swap(data, 1, size);
            size--;
            siftDown(1);
            return ret;
        }

        private void swap(int[] data, int index1, int index2) {
            int temp = data[index1];
            data[index1] = data[index2];
            data[index2] = temp;
        }

    }

    public int findKthLargest(int[] nums, int k) {
        MaxHeap maxHeap = new MaxHeap(nums);
        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }
        return maxHeap.peek();
    }
}
