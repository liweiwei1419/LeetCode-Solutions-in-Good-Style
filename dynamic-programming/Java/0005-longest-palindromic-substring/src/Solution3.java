public class Solution3 {

    // 动态规划，记录左边和最大长度

    public String longestPalindrome(String s) {
        // 特判
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int start = 0;
        // dp[j][i] 表示 s[j][i] 是否是回文串
        boolean[][] dp = new boolean[len][len];

        for (int right = 0; right < len; right++) {
            for (int left = 0; left <= right; left++) {
                if (left == right) {
                    dp[left][right] = true;
                    break;
                }
                // 小心越界问题，即 left + 1 < right - 1，即 left < right-2
                if (s.charAt(left) == s.charAt(right) && (left >= right - 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                    // 此时，区间长度为 right-left+1
                    if (right - left + 1 > maxLen) {
                        maxLen = right - left + 1;
                        start = left;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
