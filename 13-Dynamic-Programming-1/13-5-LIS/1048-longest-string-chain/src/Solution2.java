import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    // 排序是前提：按照字符串的长度排序
    // 与 第 300 题很像的地方在于：当前的状态值和之前所有的状态相关
    // 这里 dp 以 hash 表的性质存在
    // 时间复杂度: O(N \log N + N * maxLenOfWord)，这里 N 是字符串数组的长度。排序 + 双重遍历

    public int longestStrChain(String[] words) {
        int len = words.length;
        // 关键定义：key：字符串，value：以该字符串为结尾的链的长度
        Map<String, Integer> dp = new HashMap<>(len);

        // 前提：排序
        Arrays.sort(words, Comparator.comparingInt(String::length));

        for (String word : words) {
            int maxLen = 0;

            int currentWordLen = word.length();
            for (int i = 0; i < currentWordLen; i++) {
                // 枚举所有的比当前字符串少了一个字符的子串
                // word.substring(0, i) 不包括 i
                // word.substring(i + 1) 包括 i + 1
                String prev = word.substring(0, i) + word.substring(i + 1);
                maxLen = Math.max(maxLen, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(word, maxLen);
        }

        // 这里和「最长上升子序列」一样，要遍历一次，输出最长的长度
        int res = 0;
        for (int value : dp.values()) {
            res = Math.max(res, value);
        }
        return res;
    }
}