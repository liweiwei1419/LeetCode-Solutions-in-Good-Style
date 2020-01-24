public class Solution {

    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < len; i++) {
            int res = 0;
            char cur = s.charAt(i);
            if (cur != '0') {
                res += dp[i - 1];
            }
            int pre = Integer.parseInt(s.substring(i - 1, i + 1));
            if (pre <= 26 && pre >= 10) {
                if (i - 2 < 0) {
                    res++;
                } else {
                    res += dp[i - 2];
                }
            }
            dp[i] = res;
            // System.out.println(Arrays.toString(dp));
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "12";
        int numDecodings = solution.numDecodings(s);
        System.out.println(numDecodings);
    }
}
