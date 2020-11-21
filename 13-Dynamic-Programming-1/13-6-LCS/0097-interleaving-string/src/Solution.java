public class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len3 != len1 + len2) {
            return false;
        }

        char[] s1CharArray = s1.toCharArray();
        char[] s2CharArray = s2.toCharArray();
        char[] s3CharArray = s3.toCharArray();

        // 动态规划，dp[i][j] 表示 s1 的前 i 个字符能与 s2 的前 j 个字符匹配 s3 的前 i + j 个字符
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        // 初始化
        dp[0][0] = true;
        // 注意这里 break 的作用
        for (int i = 1; i <= len1; i++) {
            // 不相等直接终止
            if (s1CharArray[i - 1] == s3CharArray[i - 1]) {
                dp[i][0] = true;
            } else {
                break;
            }
        }
        for (int j = 1; j <= len2; j++) {
            // 不相等直接终止
            if (s2CharArray[j - 1] == s3CharArray[j - 1]) {
                dp[0][j] = true;
            } else {
                break;
            }
        }

        // 递推开始
        // 从 1 开始到长度，注意访问 s 的时候下标有偏移
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                boolean up = dp[i - 1][j] && s1CharArray[i - 1] == s3CharArray[i + j - 1];
                boolean left = dp[i][j - 1] && s2CharArray[j - 1] == s3CharArray[i + j - 1];
                dp[i][j] = up || left;
            }
        }
        return dp[len1][len2];
    }
}