import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution6 {

    // 先写递归，发现重复子问题，再引入记忆化

    /**
     * 记忆化递归的记忆数组，memo[i] = true 表示 s[i + 1: len - 1] 左闭右闭能拆分成字典中的单词
     */
    private int[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        // 都非空，因此无须特判
        Set<String> wordSet = new HashSet<>(wordDict);
        // 初始化为 -1 表示没有计算过
        memo = new int[len];
        for (int i = 0; i < len; i++) {
            memo[i] = -1;
        }
        return wordBreak(s, 0, len, wordSet) == 1;
    }

    /**
     * 判断 s 在 [start, len - 1] 区间里是否能够拆分成 wordSet 里面的单词
     *
     * @param s
     * @param start
     * @param len
     * @param wordSet
     * @return
     */
    private int wordBreak(String s, int start, int len, Set<String> wordSet) {
        // 先写递归终止条件，start == len 的时候，区间为空，返回 1
        if (start == len) {
            return 1;
        }

        // 如果缓存有，直接返回缓存
        if (memo[start] != -1) {
            // System.out.println(start);
            return memo[start];
        }

        for (int i = start; i < len; i++) {
            // substring 是左闭右开，所以要加上 1
            String pre = s.substring(start, i + 1);
            // 如果前半部分在 wordSet 中，需要递归判断 [i + 1, len - 1]
            if (wordSet.contains(pre)) {
                // 递归计算出的结果要保存一下
                // 注意，这里应该填 memo[i]
                memo[i] = wordBreak(s, i + 1, len, wordSet);
                if (memo[i] == 1) {
                    return 1;
                }
            }
        }
        return 0;
    }
}