/**
 * @author coder_hezi
 */
public class Solution4 {

    public boolean search(int[] nums, int target) {
        // 有重复值，直接找最小值
        if (nums == null || nums.length == 0) {
            return false;

        }
        int minIndex = findMin(nums);
        // System.out.println("最小值的索引是：" + minIndex);

        int left = 0;
        int right = nums.length - 1;
        if (nums[0] > target) {
            left = minIndex;
        } else if (nums[0] < target) {
            if (minIndex != 0) {
                right = minIndex - 1;
            }
        } else {
            return true;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] == target;
    }

    /**
     * 使用 mid 去与 right 比较
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        // 没有旋转
        if (nums[0] < nums[right]) {
            return 0;
        }
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return left;
    }
}