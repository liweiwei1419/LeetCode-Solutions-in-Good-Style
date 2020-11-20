public class Solution2 {

    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        // 最后一个数不会成为起始的数字
        for (int left = 0; left < numbers.length - 1; left++) {
            // 挨个二分查找
            int right = binarySearch(numbers, left + 1, len - 1, target - numbers[left]);
            if (right != -1) {
                return new int[]{left + 1, right + 1};
            }
        }
        throw new RuntimeException("在数组中没有找到这样的两个数，使得它们的和为指定值");
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}