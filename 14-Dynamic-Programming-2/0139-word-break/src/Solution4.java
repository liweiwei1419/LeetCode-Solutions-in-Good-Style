import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution4 {

    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        Set<String> wordSet = new HashSet<>(wordDict);

        // 状态定义：前缀子串 s[0..i] 是否能够由 wordSet 中的单词拼写而成
        boolean[] dp = new boolean[len];
        for (int right = 0; right < len; right++) {
            if (wordSet.contains(s.substring(0, right + 1))) {
                dp[right] = true;
                continue;
            }
            for (int left = 0; left < right; left++) {
                if (dp[left] && wordSet.contains(s.substring(left + 1, right + 1))) {
                    dp[right] = true;
                    break;
                }
            }
        }
        return dp[len - 1];
    }
}