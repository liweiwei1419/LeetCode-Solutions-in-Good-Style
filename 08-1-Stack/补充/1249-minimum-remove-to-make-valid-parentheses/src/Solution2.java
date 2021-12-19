import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {

    // 参考资料：https://leetcode-cn.com/problems/minimum-remove-to-make-valid-parentheses/solution/yi-chu-wu-xiao-de-gua-hao-zhan-by-97wgl/

    public String minRemoveToMakeValid(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int len = s.length();
        boolean[] invalidIndex = new boolean[len];

        char[] charArray = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (charArray[i] == '(') {
                stack.addLast(i);
                invalidIndex[i] = true;
            }
            if (charArray[i] == ')') {
                if (stack.isEmpty()) {
                    invalidIndex[i] = true;
                } else {
                    invalidIndex[stack.removeLast()] = false;
                }
            }
        }

        for (int i = 0; i < len; i++) {
            if (!invalidIndex[i]) {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}