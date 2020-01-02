import java.util.Arrays;

/**
 * @author liwei
 * @date 2019/8/10 1:47 PM
 */
public class Solution8 {

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len - k];
    }
}
