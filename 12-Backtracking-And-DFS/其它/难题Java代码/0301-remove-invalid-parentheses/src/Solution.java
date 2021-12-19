import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    // https://leetcode-cn.com/problems/remove-invalid-parentheses/solution/shan-chu-wu-xiao-de-gua-hao-by-leetcode/
    // https://leetcode-cn.com/problems/remove-invalid-parentheses/solution/301-shan-chu-wu-xiao-de-gua-hao-java-hui-su-xiang-/


    /**
     * 用集合存储所有正确的字符串，可避免重复
     */
    private Set<String> set = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        char[] ss = s.toCharArray();
        int open = 0, close = 0;
        // 获取应该去除的左右括号数
        for (char c : ss) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open > 0) {
                    open--;
                } else {
                    close++;
                }
            }
        }
        dfs(ss, new StringBuilder(), 0, 0, 0, open, close);
        return new ArrayList<>(set);
    }

    /**
     * 分别对字符串中的每一位置的字符进行处理，最终获得符合要求的字符串加入集合中
     *
     * @param ss       字符串对应的字符数组
     * @param sb       储存当前处理过且未去除字符的字符串
     * @param index    当前处理的字符位置
     * @param open     当前sb中储存的左括号数
     * @param close    当前sb中储存的右括号数
     * @param openRem  当前需要去除的左括号数
     * @param closeRem 当前需要去除的右括号数
     */
    public void dfs(char[] ss, StringBuilder sb, int index, int open, int close, int openRem, int closeRem) {
        // 所有字符都处理完毕
        if (index == ss.length) {
            // 如果应去除的左右括号数都变为0，则将sb插入set
            if (openRem == 0 && closeRem == 0) {
                set.add(sb.toString());
            }
            return;
        }
        // 去掉当前位置的字符（括号），并处理下一个字符
        if (ss[index] == '(' && openRem > 0 || ss[index] == ')' && closeRem > 0) {
            dfs(ss, sb, index + 1, open, close, openRem - (ss[index] == '(' ? 1 : 0), closeRem - (ss[index] == ')' ? 1 : 0));
        }
        // 不去掉当前位置字符
        // 将当前位置字符插入sb
        sb.append(ss[index]);
        // 当前位置不为括号，则直接处理下一个字符
        if (ss[index] != '(' && ss[index] != ')') {
            dfs(ss, sb, index + 1, open, close, openRem, closeRem);
        }
            // 当前位置为左括号，增加左括号计数，处理下一个字符
        else if (ss[index] == '(') {
            dfs(ss, sb, index + 1, open + 1, close, openRem, closeRem);
        }
            // 当前位置为右括号，且当前左括号计数大于右括号计数，则增加右括号计数，处理下一个字符
        else if (open > close) {
            dfs(ss, sb, index + 1, open, close + 1, openRem, closeRem);
        }
        // 去除当前加入sb的字符
        sb.deleteCharAt(sb.length() - 1);
    }

}
