import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    // 方法：动态规划，类似最长上升子序列

    public int findLongestChain(int[][] pairs) {
        int len = pairs.length;
        // 预处理：按照起点升序排序
        // (a, b) -> a[0] - b[0]，如果 a[0] - b[0] 小于 0，就把 a[0] 排在前面
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));

        // dp[i] 表示：以 pairs[i] 为数对链的尾巴的最大数对链长度
        int[] dp = new int[len];
        // 初始化
        Arrays.fill(dp, 1);

        // 递推开始，假设之前的链尾巴为 pairs[i]，如果 pairs[i][1] < pairs[j][0]，那么就可以把 pairs[j] 连在 pairs[i] 的后面形成更长的练
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        // 判断以每个数对为结尾的数对链中的最大值
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}