import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    // 符合后进先出，使用栈
    // 当前遍历到的元素只和栈顶比较

    // 时间复杂度：O(N)
    // 空间复杂度：O(N)

    public String removeDuplicates(String S) {
        char[] charArray = S.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : charArray) {
            // 只会消除一次，所以用 if
            if (stack.isEmpty() || c != stack.peekLast()) {
                stack.addLast(c);
            } else {
                stack.removeLast();
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : stack) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}