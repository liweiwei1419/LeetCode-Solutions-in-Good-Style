public class Solution6 {

    // 暴力法

    public int findMin(int[] nums) {
        int len = nums.length;
        int minVal = nums[0];
        for (int i = 1; i < len; i++) {
            minVal = Math.min(minVal, nums[i]);
        }
        return minVal;
    }
}
