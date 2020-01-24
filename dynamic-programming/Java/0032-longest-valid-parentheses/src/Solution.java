import java.util.Stack;

public class Solution {

    // 栈、把连续出现的那种情况考虑到

    public int longestValidParentheses(String s) {
        int maxLen = 0;
        int left = 0;
        int len = s.length();
        if (len == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if ('(' == (s.charAt(i))) {
                stack.add(i);
            } else {
                if (stack.isEmpty()) {
                    left = i + 1;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        maxLen = Math.max(maxLen, i - left + 1);
                    } else {
                        maxLen = Math.max(maxLen, i - stack.peek());
                    }
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        // write your code here
    }
}
