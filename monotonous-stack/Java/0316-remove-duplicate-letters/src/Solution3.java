import java.util.ArrayDeque;
import java.util.Deque;

public class Solution3 {

    public String removeDuplicateLetters(String s) {
        int len = s.length();
        // 特判
        if (len < 2) {
            return s;
        }

        char[] charArray = s.toCharArray();

        // 记录每个字符出现的最后一个位置
        int[] lastAppearIndex = new int[26];
        for (int i = 0; i < len; i++) {
            lastAppearIndex[charArray[i] - 'a'] = i;
        }

        // 记录是否在已经得到的字符串中
        boolean[] set = new boolean[26];

        Deque<Character> stack = new ArrayDeque<>();
        // 此时 `a` 作为哨兵，这个 `a` 永远不会被弹出
        // 如此一来，在遍历的时候，就不用判断栈是否为空了
        stack.addLast('a');

        for (int i = 0; i < len; i++) {
            char currentChar = charArray[i];
            if (set[currentChar - 'a']) {
                continue;
            }

            while (stack.peekLast() > currentChar && lastAppearIndex[stack.peekLast() - 'a'] >= i) {
                char top = stack.removeLast();
                set[top - 'a'] = false;
            }

            stack.addLast(currentChar);
            set[currentChar - 'a'] = true;
        }

        int size = stack.size();
        StringBuilder stringBuilder = new StringBuilder();
        // 注意：这里只弹栈 size - 1 次
        for (int i = 0; i < size - 1; i++) {
            stringBuilder.insert(0, stack.removeLast());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution3 solution2 = new Solution3();
        String res = solution2.removeDuplicateLetters("cbacdcbc");
        System.out.println(res);
    }
}
