public class Solution2 {

    public int numDistinct(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if (slen == 0 || tlen == 0) {
            return 0;
        }
        int[][] dp = new int[slen + 1][tlen + 1];
        for (int i = 0; i < slen; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < slen + 1; i++) {
            for (int j = 1; j < tlen + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[slen][tlen];
    }

    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";
        Solution2 solution = new Solution2();
        int numDistinct = solution.numDistinct(s, t);
        System.out.println(numDistinct);
    }
}