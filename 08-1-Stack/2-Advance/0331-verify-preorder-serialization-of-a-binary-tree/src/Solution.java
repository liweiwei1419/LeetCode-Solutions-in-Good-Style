import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public boolean isValidSerialization(String preorder) {
        String[] splits = preorder.split(",");
        int len = splits.length;

        // 特判
        if (len == 1 && "#".equals(splits[0])) {
            return true;
        }
        if (len < 3) {
            return false;
        }
        if (!"#".equals(splits[len - 1]) && !"#".equals(splits[len - 2])) {
            return false;
        }

        Deque<String> stack = new ArrayDeque<>();
        stack.push(splits[0]);

        for (int i = 1; i < len; i++) {
            while (!stack.isEmpty() && "#".equals(stack.peekLast())) {
                stack.removeLast();

                if (stack.isEmpty()) {
                    return false;
                }
                stack.removeLast();
            }
            stack.addLast(splits[i]);
        }
        return !stack.isEmpty() && "#".equals(stack.peekLast());
    }
}