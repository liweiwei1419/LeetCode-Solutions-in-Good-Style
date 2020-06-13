import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {

    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        // 预处理
        Set<String> wordSet = new HashSet<>(wordDict);

        // 状态定义：前缀子串 s[0..i) （长度为 i 的前缀子串）是否能够由 wordSet 中的单词拼写而成
        // 多开一维
        boolean[] dp = new boolean[len + 1];
        // 重点讲解这里
        dp[0] = true;
        for (int right = 1; right < len + 1; right++) {
            // 边界定义：[0, left)、[left, right]
            for (int left = 0; left < right; left++) {
                if (dp[left] && wordSet.contains(s.substring(left, right))) {
                    dp[right] = true;
                    break;
                }
            }
        }
        return dp[len];
    }


    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        Solution2 solution2 = new Solution2();
        boolean res = solution2.wordBreak(s, wordDict);
        System.out.println(res);
    }
}
