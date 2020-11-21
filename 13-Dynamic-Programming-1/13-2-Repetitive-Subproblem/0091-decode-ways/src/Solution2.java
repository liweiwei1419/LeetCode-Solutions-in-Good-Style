public class Solution2 {

    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }

        // dp[i] 以 s[i - 1] 结尾的前缀子串有多少种解法方法
        // dp[i] = dp[i - 1] * 1 if nums[i - 1] != '0'
        // dp[i] += dp[i - 2] * 1 if  10 <= int(nums[i - 2..i - 1]) <= 26

        int[] dp = new int[len + 1];
        dp[0] = 1;
        char[] charArray = s.toCharArray();
        if (charArray[0] == '0') {
            return 0;
        }
        dp[1] = 1;

        for (int i = 1; i < len; i++) {
            if (charArray[i] != '0') {
                dp[i + 1] = dp[i];
            }

            int num = 10 * (charArray[i - 1] - '0') + (charArray[i] - '0');
            if (num >= 10 && num <= 26) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[len];
    }
}