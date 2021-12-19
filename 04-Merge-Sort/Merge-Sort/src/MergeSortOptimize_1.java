public class MergeSortOptimize_1 implements ISortAlgorithm {

    /**
     * 全局使用一个数组帮助归并
     */
    private int[] temp;

    @Override
    public String getName() {
        return "归并排序算法";
    }

    @Override
    public void sort(int[] arr) {
        int len = arr.length;
        temp = new int[len];
        mergeSort(arr, 0, len - 1);
    }

    private void mergeSort(int[] arr, int left, int right) {
        // 先处理递归到底
        if (left == right) {
            return;
        }
        // 然后再二分
        int mid = left + (right - left) / 2;
        // 递归下去做这件事情，注意边界
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        mergeTwoSortedArray(arr, left, mid, right);
    }

    private void mergeTwoSortedArray(int[] arr, int left, int mid, int right) {
        int len = right - left + 1;
        System.arraycopy(arr, left, temp, left, len);
        int i = left;
        int j = mid + 1;
        // 循环遍历把 arr 在 [left,right] 这个区间重新赋值
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                // i 用完了以后，j 一直加就好了
                arr[k] = temp[j];
                j++;
            } else if (j == len) {
                // j 用完了以后，i 一直加就好了
                arr[k] = temp[i];
                i++;
            } else if (temp[i] < temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
        }
    }
}
