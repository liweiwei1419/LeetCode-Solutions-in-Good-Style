/**
 *
 */
public class Solution4 {

    private int[] temp;

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        temp = new int[len];
        mergeSort(nums, 0, len - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right + 1) >>> 1;
        // 注意：1、这样写安全，因为 mid + 1 一定有值
        mergeSort(nums, left, mid - 1);
        mergeSort(nums, mid, right);
        if (nums[mid - 1] <= nums[mid]) {
            return;
        }
        mergeOfTwoSortedArray(nums, left, mid, right);
    }

    /**
     * @param nums
     * @param left
     * @param mid   [left, mid - 1] 有序，[mid, right] 有序
     * @param right
     */
    private void mergeOfTwoSortedArray(int[] nums, int left, int mid, int right) {
        if (right + 1 - left >= 0) {
            System.arraycopy(nums, left, temp, left, right + 1 - left);
        }

        int i = left;
        int j = mid;

        for (int k = left; k <= right; k++) {
            if (i == mid) {
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
