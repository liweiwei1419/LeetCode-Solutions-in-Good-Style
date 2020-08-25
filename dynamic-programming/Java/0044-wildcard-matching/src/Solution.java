public class Solution {

    public boolean isMatch(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();


        char[] sCharArray = s.toCharArray();
        char[] pCharArray = p.toCharArray();

        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;

        for (int i = 1; i <= len2; i++) {
            if (pCharArray[i - 1] == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (pCharArray[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (pCharArray[j - 1] == '?' || sCharArray[i - 1] == pCharArray[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[len1][len2];
    }
}
