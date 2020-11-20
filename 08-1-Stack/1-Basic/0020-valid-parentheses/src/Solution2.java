import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public boolean isValid(String s) {
        int len = s.length();
        if (len == 0) {
            return true;
        }
        // 奇数长度一定不是有效括号
        if ((len % 2) == 1) {
            return false;
        }

        char[] charArray = s.toCharArray();
        Map<Character, Character> hashMap = new HashMap<>();
        hashMap.put(')', '(');
        hashMap.put(']', '[');
        hashMap.put('}', '{');

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : charArray) {
            // 如果遍历到右括号，检查是否匹配
            if (hashMap.containsKey(c)) {
                // 栈为空和栈顶与当前不匹配都不能称之为"有效"
                if (stack.isEmpty() || !hashMap.get(c).equals(stack.removeLast())) {
                    return false;
                }
            } else {
                // 遍历到左括号就加入栈
                stack.addLast(c);
            }
        }
        return stack.isEmpty();
    }
}