import java.util.Arrays;

/**
 * @author liweiwei1419
 * @date 2019/10/12 5:35 下午
 */
public class Solution6 {

    // 暴力解法
    // 时间复杂度：O(N^2)
    // 空间复杂度：O(1)，不计保存结果集的数组
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return new int[0];
        }
        int[] res = new int[len - k + 1];
        for (int i = 0; i < len - k + 1; i++) {
            res[i] = max(nums, i, i + k - 1);
        }
        return res;
    }

    private int max(int[] nums, int left, int right) {
        int max = nums[left];
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        Solution6 solution6 = new Solution6();
        int[] res = solution6.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }
}
