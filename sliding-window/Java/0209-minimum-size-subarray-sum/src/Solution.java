public class Solution {

    // 暴力解法（超时）
    // 时间复杂度：O(N^3)
    // 空间复杂度：O(1)

    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int minLen = len + 1;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }

                if (sum >= s) {
                    minLen = Math.min(minLen, j - i + 1);
                }
            }
        }

        if (minLen == len  + 1){
            return 0;
        }
        return minLen;
    }

    public static void main(String[] args) {
        int s = 15;
        int[] nums = {1, 2, 3, 4, 5};
        Solution solution = new Solution();
        int res = solution.minSubArrayLen(s, nums);
        System.out.println(res);
    }
}
