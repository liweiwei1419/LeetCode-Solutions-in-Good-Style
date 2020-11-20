import java.util.Random;

public class Solution4 {

    private static final Random RANDOM = new Random();

    /**
     * 列表大小等于或小于该大小，将优先于 quickSort 使用插入排序
     */
    private static final int QUICK_SORT_THRESHOLD = 47;

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
//        if (left >= right) {
//            return;
//        }

        // 优化 1：小区间使用插入排序
        if (right - left <= QUICK_SORT_THRESHOLD) {
            insertionSort(nums, left, right);
            return;
        }

        int randomIndex = left + RANDOM.nextInt(right - left + 1);
        swap(nums, randomIndex, left);

        // all in [left + 1, lt] < pivot
        // all in [lt + 1, i) = pivot
        // all in [gt, right] > pivot
        int pivot = nums[left];
        int lt = left;
        int gt = right + 1;

        int i = left + 1;
        while (i < gt) {
            if (nums[i] < pivot) {
                lt++;
                swap(nums, i, lt);
                i++;
            } else if (nums[i] == pivot) {
                i++;
            } else {
                gt--;
                swap(nums, i, gt);
            }
        }
        swap(nums, left, lt);
        // 注意这里，大大减少了分治的区间
        quickSort(nums, left, lt - 1);
        quickSort(nums, gt, right);
    }

    /**
     * @param nums
     * @param left
     * @param right
     */
    private void insertionSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            if (nums[i - 1] <= nums[i]) {
                continue;
            }
            int temp = nums[i];
            int j = i;
            while (j > left && nums[j - 1] > temp) {
                // 后移一位
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}