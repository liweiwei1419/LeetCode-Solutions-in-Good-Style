public class Solution {

    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }

        int[] dp = new int[len];
        char[] charArray = s.toCharArray();
        if (charArray[0] == '0'){
            dp[0] = 0;
        } else {
            dp[0] = 1;
        }

        // dp[i]：前缀字符串 s[0:i] 的解码方法数
        for (int i = 1; i < len; i++) {
            int currentValue = 0;
            char cur = charArray[i];
            if (cur != '0') {
                currentValue += dp[i - 1];
            }

            int pre = Integer.parseInt(s.substring(i - 1, i + 1));
            if (pre <= 26 && pre >= 10) {
                if (i - 2 < 0) {
                    currentValue++;
                } else {
                    currentValue += dp[i - 2];
                }
            }
            dp[i] = currentValue;
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "12";
        int res = solution.numDecodings(s);
        System.out.println(res);
    }
}
