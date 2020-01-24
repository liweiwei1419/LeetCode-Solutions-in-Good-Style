import java.util.Arrays;

public class Solution {

    // dp[i][j]：代表从 i 到 j 的最长的回文子串，
    // 更改 dp 二维矩阵的上三角，
    // 我们是斜着去更改数值的，不是一行一列那样去更改的。

    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int[][] dp = new int[len][len];

        // 对角线上都是 1

        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        for (int gap = 1; gap < len; gap++) {
            //从第一行(gap=0)开始，有几（len-gap）组(长度为n+1)的就循环几次
            for (int left = 0; gap + left < len; left++) {
                // 首先要注意：这个题不需要连续
                // 不是判断 gap + n 和 gap + gap - 1
                if (s.charAt(left) == s.charAt(left + gap)) {
                    // 这里 +2 的意思是：首和尾相等了，那长度肯定可以加上这两个
                    // 再加上从 gap + 1 到 n + left - 1这段的最长回文子序列数量
                    dp[left][gap + left] = dp[left + 1][gap + left - 1] + 2;
                } else {
                    // 判断 dp[首 + 1，尾] 和 dp[首, 尾 - 1]，取其最大值
                    dp[left][gap + left] = Math.max(dp[left + 1][gap + left], dp[left][gap + left - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
