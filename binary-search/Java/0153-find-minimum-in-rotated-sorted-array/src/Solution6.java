public class Solution6 {

    // 暴力法

    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            throw new IllegalArgumentException("数组为空");
        }
        int minimum = nums[0];
        for (int i = 1; i < len; i++) {
            minimum = Math.min(minimum, nums[i]);
        }
        return minimum;
    }
}
