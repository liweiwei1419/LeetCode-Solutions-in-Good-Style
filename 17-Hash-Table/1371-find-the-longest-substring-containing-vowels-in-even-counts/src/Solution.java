import java.util.Arrays;

public class Solution {

    public int findTheLongestSubstring(String s) {
        // dp 定义：状态为 i 的前缀异或和第 1 次出现的
        int[] dp = new int[32];
        // -1 表示未赋值
        Arrays.fill(dp, -1);

        // 前缀异或和
        int bitMap = 0;
        dp[bitMap] = 0;

        int res = 0;
        int len = s.length();

        char[] charArray = s.toCharArray();

        for (int i = 0; i < len; i++) {
            char c = charArray[i];
            if (c == 'a') {
                bitMap ^= 1;
            }
            if (c == 'e') {
                bitMap ^= (1 << 1);
            }
            if (c == 'i') {
                bitMap ^= (1 << 2);
            }
            if (c == 'o') {
                bitMap ^= (1 << 3);
            }
            if (c == 'u') {
                bitMap ^= (1 << 4);
            }

            // 先记录信息，然后再计算长度的时候，就需要 + 1
            if (dp[bitMap] >= 0) {
                res = Math.max(res, i - dp[bitMap] + 1);
            } else {
                dp[bitMap] = i + 1;
            }
        }
        return res;
    }
}