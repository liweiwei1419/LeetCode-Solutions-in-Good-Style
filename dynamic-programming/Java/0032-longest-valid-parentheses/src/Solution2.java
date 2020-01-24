public class Solution2 {

    // 动态规划

    public int longestValidParentheses(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }

        // dp[i] 表示从索引位置 i 开始的最长有效括号的长度
        int[] dp = new int[len];

        // 从后向前递推
        for (int i = len - 2; i >= 0; i--) {
            // 不可能以 ')' 开头
            if (')' == s.charAt(i)) {
                continue;
            }

            // end 是 (i + 1) 表示的最长有效括号结尾的下一位
            int end = dp[i + 1] + (i + 1);

            if (end < len && ')' == s.charAt(end)) {
                // 头和尾算上，所以加 2
                dp[i] = dp[i + 1] + 2;

                if (end + 1 < len) {
                    dp[i] += dp[end + 1];
                }
            }
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = ")()())";
        Solution2 solution2 = new Solution2();
        int longestValidParentheses = solution2.longestValidParentheses(s);
        System.out.println(longestValidParentheses);
    }
}
