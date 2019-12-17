import java.util.ArrayList;
import java.util.List;

/**
 * @author liweiwei1419
 * @date 2019/10/9 4:26 下午
 */
public class Solution3 {

    // 归并排序

    /**
     * 列表大小等于或小于该大小，将优先于 mergesort 使用插入排序
     */
    private static final int INSERTION_SORT_THRESHOLD = 7;

    public List<Integer> sortArray(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        mergeSort(nums, 0, len - 1, temp);

        List<Integer> res = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            res.add(nums[i]);
        }
        return res;
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (right - left <= INSERTION_SORT_THRESHOLD) {
            insertionSort(nums, left, right);
            return;
        }
        int mid = (left + right) >>> 1;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        if (nums[mid] <= nums[mid + 1]) {
            return;
        }
        mergeOfTwoSortedArray(nums, left, mid, right, temp);
    }

    /**
     * 对数组给定的部分使用插入排序
     *
     * @param arr   给定数组
     * @param left  左边界，能取到
     * @param right 右边界，能取到
     */
    private void insertionSort(int[] arr, int left, int right) {
        // 第 1 遍不用插入，所以是总长度减去 1
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j = i;
            while (j > left && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    /**
     * @param nums
     * @param left
     * @param mid   [left, mid] 有序，[mid + 1, right] 有序
     * @param right
     * @param temp
     */
    private void mergeOfTwoSortedArray(int[] nums, int left, int mid, int right, int[] temp) {
        // 全局使用一个 temp 数组，避免多次创建和销毁
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;

        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                // 注意 <= 保证了稳定性
                nums[k] = temp[i];
                i++;
            } else {
                // temp[i] > temp[j]
                nums[k] = temp[j];
                j++;
            }
        }
    }

}
