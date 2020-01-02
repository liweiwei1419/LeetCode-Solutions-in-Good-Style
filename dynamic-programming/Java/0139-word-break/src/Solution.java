import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        // 状态定义：以 s[i] 结尾的子字符串是否符合题意
        boolean[] dp = new boolean[len];

        // 预处理：使用哈希表判重更快
        Set<String> wordSet = new HashSet<>(wordDict);

        // 动态规划问题一般都有起点，起点也相对好判断一些
        // dp[0] = wordSet.contains(s.charAt(0));

        for (int right = 0; right < len; right++) {
            if (wordSet.contains(s.substring(0, right + 1))) {
                dp[right] = true;
                continue;
            }
            for (int left = 0; left < right; left++) {
                // dp[left] 写在前面会更快一点，否则还要去切片，然后再放入 hash 表判重
                if (dp[left] && wordSet.contains(s.substring(left + 1, right + 1))) {
                    dp[right] = true;
                    // 这个 break 很重要，一旦得到 dp[right] = True ，循环不必再继续
                    break;
                }
            }
        }
        return dp[len - 1];
    }


    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        Solution solution = new Solution();
        boolean res = solution.wordBreak(s, wordDict);
        System.out.println(res);
    }
}
