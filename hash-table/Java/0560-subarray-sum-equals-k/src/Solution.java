public class Solution {

    // 暴力解法：枚举左右边界（超时）
    // 时间复杂度：O(N^3)

    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {

                int sum = 0;
                for (int i = left; i <= right; i++) {
                    sum += nums[i];
                }
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, -1, 1, -1, 1};
        int k = 3;
        Solution solution = new Solution();
        int res = solution.subarraySum(nums, k);
        System.out.println(res);
    }
}
