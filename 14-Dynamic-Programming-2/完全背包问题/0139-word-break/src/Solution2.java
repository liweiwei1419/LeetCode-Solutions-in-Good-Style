import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int len = s.length();

        // 状态定义：以 s[i] 结尾的子字符串是否符合题意
        boolean[] dp = new boolean[len];
        for (int right = 0; right < len; right++) {
            // 分类讨论 1：不拆分，substring 右端点不包含，所以是 right + 1
            if (wordSet.contains(s.substring(0, right + 1))) {
                dp[right] = true;
                continue;
            }
            // 分类讨论 2：拆分
            for (int left = right - 1; left >= 0; left--) {
                if (wordSet.contains(s.substring(left + 1, right + 1)) && dp[left]) {
                    dp[right] = true;
                    // 这个 break 很重要，一旦得到 dp[right] = True ，循环不必再继续
                    break;
                }
            }
        }
        return dp[len - 1];
    }
}