import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution3 {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int len = s.length();
        // 状态定义：长度为 i 的子字符串是否符合题意
        boolean[] dp = new boolean[len + 1];
        // 这个状态的设置非常关键，说明前部分的字符串已经在 wordSet 中
        dp[0] = true;
        for (int right = 1; right <= len; right++) {
            for (int left = right - 1; left >= 0; left--) {
                // dp[left] 写在前面会更快一点，否则还要去切片，然后再放入 hash 表判重
                if (wordSet.contains(s.substring(left, right)) && dp[left]) {
                    dp[right] = true;
                    // 这个 break 很重要，一旦得到 dp[right] = True ，循环不必再继续
                    break;
                }
            }
        }
        return dp[len];
    }
}