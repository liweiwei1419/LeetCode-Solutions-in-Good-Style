import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public String decodeString(String s) {
        char[] charArray = s.toCharArray();

        // 保存重复几次的栈
        Deque<Integer> stack1 = new ArrayDeque<>();
        // 保存字符串的栈
        Deque<String> stack2 = new ArrayDeque<>();

        int count = 0;
        StringBuilder res = new StringBuilder();

        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = charArray[i];
            if (c >= '0' && c <= '9') {
                count = count * 10 + (c - '0');
            } else if (c == '[') {
                if (count > 0) {
                    stack1.addLast(count);
                }
                stack2.addLast(res.toString());
                res = new StringBuilder();
                count = 0;
            } else if (c == ']') {
                StringBuilder pre = new StringBuilder().append(stack2.removeLast());
                int repeatTimes = stack1.removeLast();

                pre.append(String.valueOf(res).repeat(Math.max(0, repeatTimes)));
                res = pre;

            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        // String s = "3[a]2[bc]";

        String s = "3[a2[c]]";
        Solution solution = new Solution();
        String res = solution.decodeString(s);
        System.out.println(res);
    }
}