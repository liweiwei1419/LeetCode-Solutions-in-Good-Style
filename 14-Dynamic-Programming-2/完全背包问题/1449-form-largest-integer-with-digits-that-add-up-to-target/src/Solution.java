import java.util.Arrays;

public class Solution {

    public String largestNumber(int[] cost, int target) {
        // 第 1 步：使用动态规划计算最大位数
        // dp[i][j] 表示：使用 cost 前缀区间 [0..i] 里的元素能够刚好凑成和为 j 的时候的数字的最大位数
        int[][] dp = new int[9][target + 1];
        for (int i = 0; i < 9; i++) {
            Arrays.fill(dp[i], -1);
        }
        // 初始化
        dp[0][0] = 0;
        for (int j = cost[0]; j <= target; j++) {
            if (dp[0][j - cost[0]] != -1) {
                dp[0][j] = dp[0][j - cost[0]] + 1;
            }
        }
        // 一个数一个数考虑，因此外层循环是 cost
        for (int i = 1; i < 9; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (cost[i] <= j && dp[i][j - cost[i]] != -1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - cost[i]] + 1);
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        // 判断是否有结果
        if (dp[8][target] == -1) {
            return "0";
        }

        // 第 2 步：根据第 1 步计算的结果，优先考虑数值大的放在高位，还原最大整数
        int t = target;
        // 最大整数的位数
        int len = dp[8][target];
        StringBuilder res = new StringBuilder();
        int i = 8;
        while (t > 0) {
            // 这一步选谁
            int num = -1;
            // 倒着选，如果正着选会选出最小值
            for (int j = 9; j >= 1; j--) {
                if (t >= cost[j - 1] && dp[i][t - cost[j - 1]] == len - 1) {
                    num = j;
                    break;
                }
            }
            res.append(num);
            t -= cost[num - 1];
            len--;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int[] cost = new int[]{4, 3, 2, 5, 6, 7, 2, 5, 5};
        int target = 9;
        Solution solution = new Solution();
        String res = solution.largestNumber(cost, target);
        System.out.println(res);
    }
}