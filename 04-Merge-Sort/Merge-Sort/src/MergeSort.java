public class MergeSort implements ISortAlgorithm {

    @Override
    public String getName() {
        return "归并排序";
    }

    @Override
    public void sort(int[] arr) {
        int len = arr.length;
        mergeSort(arr, 0, len - 1);
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        mergeOfTwoArray(arr, left, mid, right);
    }

    // [4, 5, 6, 7] left = 4, mid = 5
    // [0, 1, 2, 3]
    // [left, mid] 有序
    // [mid + 1, right] 有序

    private void mergeOfTwoArray(int[] arr, int left, int mid, int right) {
        // 每做一次合并，都 new 数组元素，这样不好，在后面的版本中，会改进这个问题
        int len = right - left + 1;
        int[] temp = new int[len];

        // arr 表示源数组
        // left 表示源数组要复制的起始位置
        // temp 表示目标数组
        // 0 表示目标数组被赋值的起始位置
        // len 表示要复制的长度
        // 其它语言可以使用 for 循环代替
        System.arraycopy(arr, left, temp, 0, len);

        // i 和 j 分别指向前有序数组和后有序数组的起始位置
        int i = 0;
        int j = mid - left + 1;
        for (int k = 0; k < len; k++) {
            // 先写 i 和 j 越界的情况
            if (i > mid - left) {
                arr[left + k] = temp[j];
                j++;
            } else if (j > right - left) {
                arr[left + k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                // 取 i
                arr[left + k] = temp[i];
                i++;
            } else {
                arr[left + k] = temp[j];
                j++;
            }
        }
    }
}
