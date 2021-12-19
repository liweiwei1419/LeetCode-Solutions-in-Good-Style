public class MergeSortBU implements ISortAlgorithm {

    @Override
    public String getName() {
        return "自底向上的归并排序";
    }

    /**
     * 自底向上的归并排序没有了递归的栈调用
     * 要特别注意边界值的选取
     * [0,1,2,3,4,5,6,7]
     *
     * @param arr 待排序数组
     */
    @Override
    public void sort(int[] arr) {
        int len = arr.length;
        // sz = 1, 2, 4, 8
        for (int sz = 1; sz < len; sz *= 2) {
            // left = 0, 2, 4, 6
            for (int left = 0; left < len - sz; left += 2 * sz) {
                mergeOfTwoSortArray(arr, left, left + sz - 1, Integer.min(left + sz + sz - 1, len - 1));
            }
        }
    }

    /**
     * 这一步与自顶向下的归并排序无异
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    private void mergeOfTwoSortArray(int[] arr, int left, int mid, int right) {
        if (arr[mid] < arr[mid + 1]) {
            return;
        }

        int len = right - left + 1;
        // 每一次合并都 new 开销大，应该全局只使用一个数组帮助归并
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            temp[i] = arr[left + i];
        }

        int i = 0;
        int j = mid - left + 1;
        for (int k = 0; k < len; k++) {
            if (i > mid - left) {
                arr[left + k] = temp[j];
                j++;
            } else if (j > len - 1) {
                arr[left + k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                arr[left + k] = temp[i];
                i++;
            } else {
                arr[left + k] = temp[j];
                j++;
            }
        }
    }
}
