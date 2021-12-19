import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (len == k) {
            return "0";
        }

        int remaining = len - k;
        char[] charArray = num.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : charArray) {
            while (k > 0 && !stack.isEmpty() && stack.peekLast() > c) {
                stack.removeLast();
                k--;
            }
            stack.addLast(c);
        }

        // 针对单调不减的用例，只取前面剩下的部分，针对 String num = "112"; int k = 1; 这种用例
        while (stack.size() > remaining) {
            stack.pollLast();
        }

        // 针对示例 2，去掉前导 0
        while (!stack.isEmpty() && stack.peekFirst() == '0') {
            // 恰好 Deque 有提供 removeFirst() 实现
            stack.removeFirst();
        }

        // 针对示例 3
        if (stack.isEmpty()) {
            return "0";
        }

        // 此时栈内从栈底到栈顶拼接成的字符串就是题目要求的结果
        int size = stack.size();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(stack.removeFirst());
        }
        return stringBuilder.toString();
    }
}