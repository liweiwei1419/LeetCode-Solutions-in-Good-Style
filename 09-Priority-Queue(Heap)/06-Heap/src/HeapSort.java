public class HeapSort implements ISortAlgorithm {

    @Override
    public String getName() {
        return "堆排序（原地堆排序）";
    }


    @Override
    public void sort(int[] arr) {
        // 注意：此时的索引是从 0 开始的
        // 先 heapify
        int len = arr.length;
        for (int i = (len - 1) / 2; i >= 0; i--) {
            siftDown(arr, i, len - 1);
        }
        for (int i = 0; i < len - 1; i++) {
            // 头尾交换
            swap(arr, 0, len - i - 1);
            // 再把第 1 个元素 shift down
            siftDown(arr, 0, len - i - 2);
        }
    }


    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }


    /**
     * @param arr
     * @param begin
     * @param end   数组最大的那个索引的值
     */
    private void siftDown(int[] arr, int begin, int end) {
        while (2 * begin + 1 <= end) {
            int k = 2 * begin + 1;
            if (k + 1 <= end && arr[k] < arr[k + 1]) {
                k = k + 1;
            }
            if (arr[k] < arr[begin]) {
                break;
            }
            swap(arr, k, begin);
            begin = k;
        }
    }
}
