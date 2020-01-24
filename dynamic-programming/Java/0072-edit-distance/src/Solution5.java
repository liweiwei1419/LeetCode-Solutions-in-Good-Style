import java.util.Arrays;

public class Solution5 {

    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        // 状态转移方程：dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
        // 初始化

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }


        // 打印输出
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println();

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                    continue;
                }
                dp[i + 1][j + 1] = Math.min(dp[i][j + 1], Math.min(dp[i + 1][j], dp[i][j])) + 1;
            }
        }

        // 打印输出
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        return dp[len1][len2];
    }


    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        String word1 = "horse";
        String word2 = "ros";
        int res = solution5.minDistance(word1, word2);
        System.out.println(res);
    }
}

