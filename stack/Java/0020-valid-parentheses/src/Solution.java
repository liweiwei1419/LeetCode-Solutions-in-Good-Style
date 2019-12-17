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
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            switch (c) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                default:
                    if (stack.isEmpty() || stack.pop() != c) {
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

