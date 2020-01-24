public class Solution4 {

//    先反转原字符串, 求出反转后的字符串与原字符串的最长公共子序列
//    用字符串长度减去最长公共子序列的长度即是答案
//    循环 i 从字符串的尾部开始, 代表反转后的字符串

    public int minInsertions(String s) {
        char[] a = s.toCharArray();
        int[] dp = new int[a.length + 1];
        // 存放 dp[i-1][j-1]
        int previous = 0;
        // 用于交换 dp[k] 和 previous
        int swap = 0;
        // 避免循环中判断 j > 0
        int k = 1;

        for (int i = a.length - 1; i >= 0; i--) {
            for (char c : a) {
                swap = dp[k];
                if (a[i] == c) {
                    dp[k] = previous + 1;
                } else {
                    dp[k] = Math.max(dp[k], dp[k - 1]);
                }
                previous = swap;
                k++;
            }
            previous = 0;
            k = 1;
        }

        return a.length - dp[a.length];
    }
}
