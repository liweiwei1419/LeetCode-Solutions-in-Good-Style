public class Solution6 {

    // 动态规划

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        int maxLen = 1;
        int start = 0;

        for (int right = 1; right < len; right++) {
            for (int left = 0; left < right; left++) {
                if (s.charAt(left) != s.charAt(right)) {
                    dp[left][right] = false;
                } else {
                    if (right - left <= 2) {
                        dp[left][right] = true;
                    } else {
                        dp[left][right] = dp[left + 1][right - 1];
                    }
                }

                if (dp[left][right]) {
                    int curLen = right - left + 1;
                    if (curLen > maxLen) {
                        maxLen = curLen;
                        start = left;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        String longestPalindrome = solution6.longestPalindrome("ccc");
        System.out.println(longestPalindrome);
    }
}
