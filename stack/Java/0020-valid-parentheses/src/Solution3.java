import java.util.Stack;

/**
 * @author liweiwei1419
 * @date 2019/8/22 10:32 PM
 */
public class Solution3 {

    public boolean isValid(String s) {
        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (Character d : c) {
            switch (d) {
                case '{':
                    stack.push('{');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case '(':
                    stack.push('(');
                    break;
                case '}':
                    if (!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else{
                        return false;
                    }
                    break;
                case ')':
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        return stack.isEmpty();
    }
}


