import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {

    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        Set<String> wordSet = new HashSet<>(wordDict);

        // 前缀子串 s[0..i) （长度为 i 的前缀子串）是否能够由 wordSet 中的单词拼写而成
        boolean[] dp = new boolean[len + 1];
        // 当 s[0..right] 恰好在 wordSet 中时，需要 dp[0] 的值为 true
        dp[0] = true;
        for (int right = 1; right < len + 1; right++) {
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
