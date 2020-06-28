import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;


public class Solution {

    public boolean isValid(String s) {
        int len = s.length();
        if (len == 0) {
            return true;
        }

        if ((len & 1) == 1) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

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

