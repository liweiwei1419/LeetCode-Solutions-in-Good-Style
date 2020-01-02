/**
 * @author liweiwei1419
 * @date 2019/11/19 4:06 下午
 */
public class Solution {

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int left = 0;
        int right = len;

        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                return mid;
            } else {
                // nums[mid] > target
                right = mid;
            }
        }
        return left;
    }
}
