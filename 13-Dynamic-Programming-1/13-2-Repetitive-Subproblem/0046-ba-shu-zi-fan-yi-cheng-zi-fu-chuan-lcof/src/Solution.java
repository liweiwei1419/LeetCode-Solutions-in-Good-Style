public class Solution {

    public int translateNum(int num) {
        // 不建议用 String s = num + "";
        String s = String.valueOf(num);
        int len = s.length();
        if (len < 2) {
            return len;
        }

        char[] charArray = s.toCharArray();
        // dp[i]：s[0..i] 能翻译的种类数
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1];
            int currentNum = 10 * (charArray[i - 1] - '0') + (charArray[i] - '0');
            if (currentNum > 9 && currentNum < 26) {
                if (i - 2 < 0) {
                    dp[i]++;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[len - 1];
    }
}