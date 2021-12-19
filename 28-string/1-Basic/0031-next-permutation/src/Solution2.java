public class Solution2 {

    // 找规律，可以认为是数学题

    public void nextPermutation(int[] nums) {
        // 1、从右边向左边第 1 个降序的位置
        int firstDownIndexFromRight = findFirstDownIndexFromRight(nums);
        if (firstDownIndexFromRight == 0) {
            reverse(nums, 0);
            return;
        }
        // 2、把逆序区的前一位和逆序区中第 1 个大于它的那个数交换
        findFirstLargerAndSwap(nums, firstDownIndexFromRight);
        // 把原来的逆序区调整为顺序区
        reverse(nums, firstDownIndexFromRight);
    }

    private void findFirstLargerAndSwap(int[] nums, int index) {
        // 把逆序区的前一位和逆序区中第 1 个大于它的那个数交换
        int pivot = nums[index - 1];
        // 找到第 1 个大于它的数
        int left = index;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            // 注意：下面这里是等于
            if (nums[mid] <= pivot) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        swap(nums, index - 1, left);
    }

    private void reverse(int[] nums, int begin) {
        int left = begin;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    private int findFirstDownIndexFromRight(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                // 注意：这里不能返回 i - 1
                return i;
            }
        }
        return 0;
    }
}