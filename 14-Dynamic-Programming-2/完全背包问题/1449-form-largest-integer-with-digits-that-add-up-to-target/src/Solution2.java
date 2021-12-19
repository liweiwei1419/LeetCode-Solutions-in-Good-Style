import java.util.Arrays;

public class Solution2 {

    public String largestNumber(int[] cost, int target) {
        // dp[i] 表示：和为 i 的时候最长可以填多少个数字
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int c : cost) {
            for (int i = c; i <= target; i++) {
                if (dp[i - c] != -1) {
                    dp[i] = Math.max(dp[i], dp[i - c] + 1);
                }
            }
        }
        // 判断是否有结果
        if (dp[target] == -1) {
            return "0";
        }

        // 在有结果的前提下，倒序反推路径
        int t = target;
        int len = dp[target];
        StringBuilder res = new StringBuilder();
        while (t > 0) {
            int num = -1;
            // 倒着选，如果正着选会选出最小值
            for (int i = 9; i > 0; i--) {
                if (t >= cost[i - 1] && dp[t - cost[i - 1]] == len - 1) {
                    num = i;
                    break;
                }
            }
            res.append(num);
            t -= cost[num - 1];
            len--;

        }
        return res.toString();
    }
}