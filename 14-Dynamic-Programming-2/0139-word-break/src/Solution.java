import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> hashSet = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        // 初始化：理解这一点非常重要，如果整个前缀就在 hashSet 中，dp[0] = true; 是一个正确的参考值
        dp[0] = true;
        // 注意：右边界 right 不可取到
        for (int right = 1; right <= len; right++) {
            // 注意：这里是倒序
            for (int i = right - 1; i >= 0; i--) {
                dp[right] = dp[i] && hashSet.contains(s.substring(i, right));
                // 注意这一步
                if (dp[right]) {
                    break;
                }
            }
        }
        return dp[len];
    }
}