import java.util.Stack;

public class Solution2 {

    public String smallestSubsequence(String text) {
        int len = text.length();
        // 从索引 i 到索引 size - 1 的位掩码
        int[] post = new int[len];
        int pre = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                // System.out.println(text.charAt(j));
                post[i] |= (1 << (text.charAt(j) - 'a'));
            }
        }

        // System.out.println(Arrays.toString(post));
        for (int i = 0; i < len; i++) {
            Character c = text.charAt(i);
            if ((pre & (1 << (c - 'a'))) > 0) {
                continue;
            }
            while (!stack.empty() && c < stack.peek() &&
                    (post[i] & (1 << (stack.peek() - 'a'))) != 0) {
                Character top = stack.pop();
                pre ^= (1 << top - 'a');
            }
            pre |= (1 << c - 'a');
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}