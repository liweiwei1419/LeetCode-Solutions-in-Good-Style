public class Solution3 {

    public int massage(int[] nums) {
        int len = nums.length;

        // dp 数组多设置一行，相应地定义就要改变，遍历的一些细节也要相应改变
        // dp[i][0]：区间 [0, i) 里接受预约请求，并且下标为 i 的这一天不接受预约的最大时长
        // dp[i][1]：区间 [0, i) 里接受预约请求，并且下标为 i 的这一天接受预约的最大时长
        int[][] dp = new int[len + 1][2];

        // 注意：外层循环从 1 到 =len，相对 dp 数组而言，引用到 nums 数组的时候就要 -1
        for (int i = 1; i <= len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i - 1];
        }
        return Math.max(dp[len][0], dp[len][1]);
    }

    public static void main(String[] args) {
        Solution3 solution2 = new Solution3();
        // int[] nums = {1, 2, 3, 1};
        // int[] nums = {2, 7, 9, 3, 1};
        int[] nums = {2, 1, 4, 5, 3, 1, 1, 3};
        int res = solution2.massage(nums);
        System.out.println(res);
    }
}
