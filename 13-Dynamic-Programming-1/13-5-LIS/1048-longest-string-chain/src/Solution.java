import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    // 不是很好理解

    public int longestStrChain(String[] words) {
        // 按照字符串的长度升序排序
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int len = words.length;
        // dp[i] 表示从 words[0] 到 words[i] 最长的词链长度
        int[] dp = new int[len];

        int res = 0;
        for (int i = 0; i < len; i++) {
            String a = words[i];
            for (int j = i + 1; j < len; j++) {
                String b = words[j];

                if (isPredecessor(a, b)) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                    res = Math.max(dp[j], res);
                }
            }
        }
        return res + 1;
    }

    /**
     * 判断 a 是否是 b 的前身
     *
     * @param a
     * @param b
     * @return "bda" 是 "bdca" 的前身，返回true
     */
    private boolean isPredecessor(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        if ((aLen + 1) != bLen) {
            return false;
        }

        int i = 0;
        int j = 0;
        // 在 word1 的任何地方添加一个字母
        while (i < aLen && j < bLen) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == aLen;
    }
}