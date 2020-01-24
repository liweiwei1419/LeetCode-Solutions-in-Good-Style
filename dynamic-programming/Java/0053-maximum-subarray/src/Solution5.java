public class Solution5 {

    // 暴力解法
    // 时间复杂度：O(N^3)
    // 空间复杂度：O(1)

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                // System.out.println(j + " " + i);
                int sum = sumOfSubArray(nums, j, i);
                res = Math.max(res, sum);

            }
            // System.out.println();
        }
        return res;
    }

    private int sumOfSubArray(int[] nums, int left, int right) {
        // 子区间的和
        int res = 0;
        for (int i = left; i <= right; i++) {
            res += nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        // int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums = new int[]{1};
        Solution5 solution5 = new Solution5();
        int res = solution5.maxSubArray(nums);
        System.out.println(res);
    }
}
