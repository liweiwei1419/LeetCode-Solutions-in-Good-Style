import java.util.Arrays;
import java.util.Comparator;

public class Solution3 {

    public int longestStrChain(String[] words) {
        int len = words.length;
        // 预处理
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int[] dp = new int[len];
        // 初始化
        Arrays.fill(dp, 1);
        // 开始递推
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (contains(words[i], words[j])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * @param a
     * @param b
     * @return b 是否为 a 的前身
     */
    private boolean contains(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        char[] charArrayA = a.toCharArray();
        char[] charArrayB = b.toCharArray();
        if (len1 != len2 + 1) {
            return false;
        }

        int i = 0;
        int j = 0;
        while (i < len1 && j < len2) {
            if (charArrayA[i] == charArrayB[j]) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == len2;
    }
}