public class Solution {

    public int minDistance(String word1, String word2) {
        char[] word1Array = word1.toCharArray();
        char[] word2Array = word2.toCharArray();

        int len1 = word1Array.length;
        int len2 = word2Array.length;

        int[][] dp = new int[len1 + 1][len2 + 1];
        // 当 word 2 长度为 0 时，将 word1 的全部删除即可
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }
        //当 word1 长度为 0 时，就插入所有 word2 的字符即可
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                // 第 i 个字符代表的是下标为 i - 1
                if (word1Array[i] == word2Array[j]) {
                    dp[i + 1][j + 1] = dp[i ][j ];
                    continue;
                }
                // 在 i 处插入一个字符
                int insert = dp[i + 1][j] + 1;
                // 替换一个字符
                int change = dp[i][j] + 1;
                // 删除一个字符
                int delete = dp[i][j + 1] + 1;
                dp[i + 1][j + 1] = Math.min(Math.min(insert, change), delete);

            }
        }
        return dp[len1][len2];
    }
}
