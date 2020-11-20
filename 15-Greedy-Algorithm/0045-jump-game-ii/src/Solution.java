public class Solution {

    // 从前向后，只关心最远值，时间复杂度：O(N)

    public int jump(int[] nums) {
        int len = nums.length;
        int end = 0;
        int maxPosition = 0;
        int res = 0;
        for (int i = 0; i < len - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                // 遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                res++;
            }
        }
        return res;
    }
}