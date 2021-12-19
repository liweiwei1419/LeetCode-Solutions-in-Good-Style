import java.util.ArrayDeque;
import java.util.Deque;


public class Solution {

    public boolean isValid(String s) {
        int len = s.length();
        // 特殊情况判断
        if ((len % 2) == 1) {
            return false;
        }

        char[] charArray = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : charArray) {
            switch (c) {
                case '(':
                    stack.addLast(')');
                    break;
                case '[':
                    stack.addLast(']');
                    break;
                case '{':
                    stack.addLast('}');
                    break;
                default:
                    if (stack.isEmpty() || stack.removeLast() != c) {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }
}