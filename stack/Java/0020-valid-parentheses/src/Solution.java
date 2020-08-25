import java.util.ArrayDeque;
import java.util.Deque;


public class Solution {

    public boolean isValid(String s) {
        int len = s.length();
        if (len == 0) {
            return true;
        }
        if ((len % 2) == 1) {
            return false;
        }

        char[] charArray = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char c:charArray) {
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

    // 括号匹配问题
    public static void main(String[] args) {
        String s = "()[]{}";
        Solution solution = new Solution();
        boolean valid = solution.isValid(s);
        System.out.println(valid);
    }
}

