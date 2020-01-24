public class Solution2 {

    /**
     * 和 Solution 一样，空间复杂度更小
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        // 起名叫 pre 表示的意思是“上一个状态”的值
        int pre = nums[0];
        int res = pre;
        for (int i = 1; i < len; i++) {
            pre = Math.max(nums[i], pre + nums[i]);
            res = Math.max(res, pre);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Solution2 solution = new Solution2();
        int maxSubArray = solution.maxSubArray(nums);
        System.out.println(maxSubArray);
    }
}