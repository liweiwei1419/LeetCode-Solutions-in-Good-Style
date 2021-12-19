import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    // 方法一：栈
    // 参考资料：孙愉芳整理的笔记
    // 搞懂题目意思：
    // 时间复杂度：$O(N)$；
    // 空间复杂度：$O(N)$

    public String minRemoveToMakeValid(String s) {
        // 只存储括号
        Deque<Character> stack = new ArrayDeque<>();

        int len = s.length();
        char[] charArray = s.toCharArray();

        // 只存储字符
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = charArray[i];
            if (c >= 97) {
                // 如果是小写字符，直接加到 stringBuilder 中
                stringBuilder.append(c);
            } else if (c == 41) {
                // 如果是右括号
                if (stack.isEmpty()) {
                    continue;
                } else {
                    stack.removeLast();
                    stringBuilder.append(c);
                }
            } else {
                // 左括号加入栈中，也加入 stringBuilder 中
                stack.addLast(c);
                stringBuilder.append(c);
            }
        }

        // 输出：删除没有用的左括号
        for (int i = 0; i < stack.size(); i++) {
            stringBuilder.deleteCharAt(stringBuilder.lastIndexOf("("));
        }
        return stringBuilder.toString();
    }
}