import java.util.HashSet;
import java.util.Set;

public class Solution {

    public String toGoatLatin(String S) {
        // vowel 元音字符
        Set<Character> vowel = new HashSet<>();
        for (char c : new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}) {
            vowel.add(c);
        }
        // 索引的个数
        int t = 1;
        StringBuilder res = new StringBuilder();
        for (String word : S.split("\\s")) {
            char first = word.charAt(0);
            // 题目要求的第 1 条
            if (vowel.contains(first)) {
                res.append(word);
            } else {
                // 题目要求的第 2 条
                res.append(word.substring(1));
                res.append(word.charAt(0));
            }
            res.append("ma");
            // 题目要求的第 3 条
            res.append("a".repeat(Math.max(0, t)));
            res.append(" ");
            t++;
        }
        // 删除最后一个空格
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
}