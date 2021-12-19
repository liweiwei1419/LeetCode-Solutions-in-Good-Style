import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public int calPoints(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String op : ops) {
            if ("+".equals(op)) {
                // 为了看到第 2 个数，第 1 个数得 pop 掉，然后再放回栈
                int score1 = stack.removeLast();
                int score2 = stack.peekLast();

                stack.addLast(score1);
                stack.addLast(score1 + score2);
            } else if ("C".equals(op)) {
                stack.removeLast();
            } else if ("D".equals(op)) {
                int score = stack.peekLast();
                stack.addLast(score * 2);
            } else {
                stack.addLast(Integer.parseInt(op));
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.removeLast();
        }
        return res;
    }
}