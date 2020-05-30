import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {

    // a c d c：注意这种情况，如果当前字符的字典序的确在上一次看到的字符字典序之前，
    // 但是它已经在之前读到过，那么这个字符其实我们是不需要的
    // 因为这个字符的位置不能比已经出现的那个字符的位置更靠前了


    public String removeDuplicateLetters(String s) {
        int len = s.length();
        // 特判
        if (len < 2) {
            return s;
        }

        char[] charArray = s.toCharArray();

        // 记录是否在已经得到的字符串中
        boolean[] set = new boolean[26];

        // 记录每个字符出现的最后一个位置
        int[] lastAppearIndex = new int[26];
        for (int i = 0; i < len; i++) {
            lastAppearIndex[charArray[i] - 'a'] = i;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            char currentChar = charArray[i];
            if (set[currentChar - 'a']) {
                continue;
            }

            while (!stack.isEmpty() && stack.peekLast() > currentChar && lastAppearIndex[stack.peekLast() - 'a'] >= i) {
                char top = stack.removeLast();
                set[top - 'a'] = false;
            }

            stack.addLast(currentChar);
            set[currentChar - 'a'] = true;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.insert(0, stack.removeLast());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String res = solution2.removeDuplicateLetters("cbacdcbc");
        System.out.println(res);
    }
}
