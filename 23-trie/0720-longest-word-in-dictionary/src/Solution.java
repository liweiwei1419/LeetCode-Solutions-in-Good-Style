import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    // 方法一：暴力解法

    public String longestWord(String[] words) {
        int len = words.length;
        if (len == 0) {
            return "";
        }
        // 第 1 步：为了判重方便，把 words 放进哈希表中
        Set<String> hashSet = new HashSet<>(Arrays.asList(words).subList(0, len));
        // 第 2 不：按照长度从小到大排序、相同长度的话，按字典序
        Comparator<String> comparator = (o1, o2) -> {
            int len1 = o1.length();
            int len2 = o2.length();
            if (len1 == len2) {
                // 注意这里的顺序，因为题目中说：若其中有多个可行的答案，则返回答案中字典序最小的单词。
                return o2.compareTo(o1);
            }
            return len1 - len2;
        };
        Arrays.sort(words, comparator);
        // 第 3 步：从后向前遍历
        for (int i = len - 1; i >= 0; i--) {
            if (judgeWordInDict(words[i], hashSet)) {
                return words[i];
            }
        }
        return "";
    }

    private boolean judgeWordInDict(String word, Set<String> dict) {
        int len = word.length();
        for (int i = 0; i < len - 1; i++) {
            if (!dict.contains(word.substring(0, i + 1))) {
                return false;
            }
        }
        return true;
    }
}