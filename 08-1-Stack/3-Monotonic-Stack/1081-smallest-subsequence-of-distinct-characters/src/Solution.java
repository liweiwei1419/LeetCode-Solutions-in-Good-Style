import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public String smallestSubsequence(String text) {
        int len = text.length();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            Character c = text.charAt(i);
            if (stack.contains(c)) {
                continue;
            }
            while (!stack.isEmpty() && c < stack.peekLast() && text.indexOf(stack.peekLast(), i) != -1) {
                stack.removeLast();
            }
            stack.addLast(c);
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}