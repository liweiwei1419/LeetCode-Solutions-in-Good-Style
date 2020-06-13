import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        // 题目说 s 和 wordDict 因此无需做判断
        // 预处理：使用哈希表判重更快
        Set<String> wordSet = new HashSet<>(wordDict);

        // 状态定义：前缀子串 s[0..i] 是否能够由 wordSet 中的单词拼写而成
        boolean[] dp = new boolean[len];

        // 动态规划「自底向上」的思路：由空串开始，一点一点向着更大规模的问题考虑
        for (int right = 0; right < len; right++) {
            if (wordSet.contains(s.substring(0, right + 1))) {
                dp[right] = true;
                continue;
            }

            // 否则枚举所有可能划分的边界，边界定义 [0..left]、[left + 1, right]
            for (int left = 0; left < right; left++) {
                // dp[left] 写在前面会更快一点，否则还要去切片，然后再放入 hash 表判重
                if (dp[left] && wordSet.contains(s.substring(left + 1, right + 1))) {
                    dp[right] = true;
                    // 这个 break 很重要，一旦得到 dp[right] = True ，循环不必再继续
                    // 因为题目只问我们是否可以拆分，没有问拆分的具体结果
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
