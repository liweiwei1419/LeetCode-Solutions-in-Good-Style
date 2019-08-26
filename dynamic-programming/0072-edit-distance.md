状态的定义很关键，一维不够，所以需要二维，类似的做法是 LeetCode 第 10 题。

`dp[i][j]` ：word1 的前 i 个字符匹配到 word2 的前 j 个字符的最少操作数。

状态转移方程，一般是分类讨论，分类讨论标准写好了，状态转移方程就写出来了：

1、从最简单的情况开始讨论；

如果末尾正好相等，直接拿过来即可

2、考虑删除、添加、替换三种操作

（1）因为对称性，我们考虑从 word1 到 word2 的操作数即可

情况 1：`dp[i - 1][j] + 1`

表示在 word1 的末尾添加 1 个字符就能与 word2 匹配了

情况 2：`dp[i][j - 1] + 1`

表示在 word1 的末尾删除 1 个字符就能与 word2 匹配了

情况 3：`dp[i - 1][j - 1] + 1`

表示把 word1 的末尾那个字符修改成 word2 末尾的那个字符就匹配了

以上三者取最小值。

```java
public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
```
