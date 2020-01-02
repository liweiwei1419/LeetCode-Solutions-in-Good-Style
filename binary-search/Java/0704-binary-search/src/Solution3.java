/**
 * @author liweiwei1419
 * @date 2019/11/2 3:23 下午
 */
public class Solution3 {

    // 目前不太懂到底怎么用这个模板

    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        int left = 0;
        int right = len - 1;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }
        return -1;
    }
}
