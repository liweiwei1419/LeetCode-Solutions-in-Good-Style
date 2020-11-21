public class Solution2 {

    public int translateNum(int num) {
        // 不建议用 String s = num + "";
        String s = String.valueOf(num);
        int len = s.length();
        if (len < 2) {
            return len;
        }

        char[] charArray = s.toCharArray();
        // dp[i]：字符串 s[0..i) 能翻译成小写字母的种数
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < len; i++) {
            // 当前字母只能至少 1 种翻译方法
            dp[i + 1] = dp[i];
            int currentNum = 10 * (charArray[i - 1] - '0') + (charArray[i] - '0');
            if (currentNum > 9 && currentNum < 26) {
                // 当前字母与前一个字母构成一种翻译方法
                dp[i + 1] = dp[i] + dp[i - 1];
            }
        }
        return dp[len];
    }
}