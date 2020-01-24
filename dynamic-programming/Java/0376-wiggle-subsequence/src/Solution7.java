public class Solution3 {

    // 动态规划
    // 思路：结尾的那个数字很重要
    // 注意：摆动序列的最长子序列的长度

    // dp[i][0] 表示以 i 结尾的数字是严格上升的
    // dp[i][1] 表示以 i 结尾的数字是严格下降的

    // 状态转移方程：只看结尾和前一个数的关系
    // 初始化：dp[0][0] = 1，dp[0][1] = 1

    // 这是比较容易想到的
    // dp[i][0] = dp[i - 1][1] + 1, if nums[i] - nums[i - 1] > 0
    // dp[i][1] = dp[i - 1][0] + 1, if nums[i] - nums[i - 1] < 0

    // 分析到这里，知道需要分类讨论

    // 输出：拉通看最大值

    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }

        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 1; i < len; i++) {
            if (nums[i - 1] < nums[i]) {
                // 结尾时候的状态是严格上升的
                dp[0] = dp[1] + 1;
            } else if (nums[i - 1] > nums[i]) {
                // 结尾时候的状态是严格下降的
                dp[1] = dp[0] + 1;
            }
        }
        return Math.max(dp[0], dp[1]);
    }

    public static void main(String[] args) {
        // int[] nums = {1, 7, 4, 9, 2, 5};
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        Solution3 solution3 = new Solution3();
        int res = solution3.wiggleMaxLength(nums);
        System.out.println(res);
    }
}
