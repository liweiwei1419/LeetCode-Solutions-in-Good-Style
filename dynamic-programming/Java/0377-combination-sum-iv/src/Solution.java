public class Solution {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        // 这一步很关键，想想为什么 dp[0] 是 1
        // 因为 0 表示空集，空集和它"前面"的元素凑成一种解法，所以是 1
        // 这一步要加深体会
        dp[0] = 1;
        for (int i = 1; i < target + 1; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] = dp[i] + dp[i - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        int target = 4;
        int combinationSum4 = solution.combinationSum4(nums, target);
        System.out.println(combinationSum4);
    }
}
