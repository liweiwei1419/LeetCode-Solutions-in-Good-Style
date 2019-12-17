import java.util.Stack;

/**
 * @author liweiwei1419
 * @date 2019/8/22 7:41 PM
 */
public class Solution2 {

    public boolean isValid2(String s) {
        int len = s.length();
        if (len == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                stack.push(')');
            } else if (s.charAt(i) == '[') {
                stack.push(']');
            } else if (s.charAt(i) == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || stack.pop() != s.charAt(i)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
