/**
 * @author liweiwei1419
 * @date 2019/10/31 4:39 下午
 */
public class Solution11 {

    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;

        k = nums.length - k;
        while (left <= right) {
            int p = partition(nums, left, right);
            if (k < p) {
                right = p - 1;
            } else if (k > p) {
                left = p + 1;
            } else {
                return nums[p];
            }
        }
        return nums[0];
    }

    private int partition(int[] nums, int left, int right) {
        int t = nums[left];
        while (left < right) {
            while (left < right & nums[right] >= t) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right & nums[left] < t) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = t;
        return left;
    }
}
