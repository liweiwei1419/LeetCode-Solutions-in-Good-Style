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
        StringBuilder ans = new StringBuilder();
        for (String word : S.split("\\s")) {
            char first = word.charAt(0);
            // 题目要求的第 1 条
            if (vowel.contains(first)) {
                ans.append(word);
            } else {
                // 题目要求的第 2 条
                ans.append(word.substring(1));
                ans.append(word.substring(0, 1));
            }
            ans.append("ma");
            // 题目要求的第 3 条
            for (int i = 0; i < t; i++) {
                ans.append('a');
            }
            ans.append(" ");
            t++;
        }
        // 删除最后一个空格
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String S = "I speak Goat Latin";
        String goatLatin = solution.toGoatLatin(S);
        System.out.println(goatLatin);
    }
}
