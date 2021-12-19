public class MergeSortOptimize implements ISortAlgorithm {

    private int[] buff;

    @Override
    public String getName() {
        return "归并排序性能优化1";
    }

    @Override
    public void sort(int[] arr) {
        int len = arr.length;
        buff = new int[len];
        mergeSort(arr, 0, len - 1);
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (right - left <= 15) {
            insertSort(arr, left, right);
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        if (arr[mid] <= arr[mid + 1]) {
            return;
        }
        mergeOfTwoSortArray(arr, left, mid, right);
    }

    /**
     * 对数组给定的部分使用插入排序
     *
     * @param arr   给定数组
     * @param left  左边界，能取到
     * @param right 右边界，能取到
     */
    private void insertSort(int[] arr, int left, int right) {
        // 第 1 遍不用插入，所以是总长度减去 1
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j;
            for (j = i - 1; j >= left; j--) {
                // 后移一位
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private void mergeOfTwoSortArray(int[] arr, int left, int mid, int right) {
        int len = right - left + 1;
        System.arraycopy(arr, left, buff, left, len);
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                arr[k] = buff[j];
                j++;
            } else if (j == len) {
                arr[k] = buff[i];
                i++;
            } else if (buff[i] < buff[j]) {
                arr[k] = buff[i];
                i++;
            } else {
                arr[k] = buff[j];
                j++;
            }
        }
    }
}
