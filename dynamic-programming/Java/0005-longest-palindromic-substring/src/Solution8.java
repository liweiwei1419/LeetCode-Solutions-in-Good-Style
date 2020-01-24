import java.util.Arrays;

public class Solution8 {

    // 写对代码的方法是：从小到大

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int[][] dp = new int[len][len];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        // 初始化
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        int maxLen = 1;
        int start = 0;

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = 0;
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i, j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] == 1) {
                    int curLen = j - i + 1;
                    if (curLen > maxLen) {
                        maxLen = curLen;
                        start = i;

                    }
                }
                printDpTable(dp);
            }
        }
        return s.substring(start, start + maxLen);
    }

    private void printDpTable(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (dp[i][j] == 1) {
                    System.out.print("1 ");
                }

                if (dp[i][j] == 0) {
                    System.out.print("0 ");
                }

                if (dp[i][j] == -1) {
                    System.out.print("  ");
                }

            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        String longestPalindrome = solution8.longestPalindrome("abcdcba");
        System.out.println(longestPalindrome);
    }
}
