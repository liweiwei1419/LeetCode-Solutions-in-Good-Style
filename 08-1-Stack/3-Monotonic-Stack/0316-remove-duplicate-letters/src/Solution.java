import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    // 方法一：栈

    public String removeDuplicateLetters(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        // 转成字符数组是因为，s.charAt(i) 会检查字符串的下标是否越界，事实上没有必要
        // 遍历字符串之前，先转换成字符数组是常见的做饭
        char[] charArray = s.toCharArray();

        // 第 1 步：记录每个字符出现的最后一个位置
        int[] lastIndex = new int[26];
        for (int i = 0; i < len; i++) {
            lastIndex[charArray[i] - 'a'] = i;
        }

        // 第 2 步：使用栈得到题目要求字典序最小的字符串
        Deque<Character> stack = new ArrayDeque<>(len);
        // 栈中有的字符记录在这里
        boolean[] visited = new boolean[26];
        for (int i = 0; i < len; i++) {
            char currentChar = charArray[i];
            if (visited[currentChar - 'a']) {
                continue;
            }

            while (!stack.isEmpty() && currentChar < stack.peekLast() && lastIndex[stack.peekLast() - 'a'] > i) {
                char top = stack.removeLast();
                // 在出栈、入栈的时候，都需要维护 visited 数组的定义
                visited[top - 'a'] = false;
            }

            stack.addLast(currentChar);
            visited[currentChar - 'a'] = true;
        }

        // 第 3 步：此时 stack 就是题目要求字典序最小的字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : stack) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}