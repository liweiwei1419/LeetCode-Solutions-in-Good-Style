public class Solution2 {

    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        int[][] dp = new int[m + 1][n + 1];

        // 先求最长公共子串
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (charArray1[i] == charArray2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        int i = m;
        int j = n;

        StringBuilder stringBuilder = new StringBuilder();
        while (i > 0 || j > 0) {
            char current = ' ';
            if (i == 0) {
                current = charArray2[j - 1];
                j--;
            } else if (j == 0) {
                current = charArray1[i - 1];
                i--;
            } else if (charArray1[i - 1] == charArray2[j - 1]) {
                current = charArray1[i - 1];
                i--;
                j--;
            } else if (dp[i - 1][j] == dp[i][j]) {
                current = charArray1[i - 1];
                i--;
            } else if (dp[i][j - 1] == dp[i][j]) {
                current = charArray2[j - 1];
                j--;
            }
            stringBuilder.append(current);
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        String str1 = "abac";
        String str2 = "cab";

        Solution2 solution2 = new Solution2();
        String res = solution2.shortestCommonSupersequence(str1, str2);
        System.out.println(res);
    }
}
