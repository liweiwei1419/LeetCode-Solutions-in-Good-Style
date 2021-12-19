import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public int getDecimalValue(ListNode head) {
        ListNode curNode = head;
        Deque<Integer> stack = new ArrayDeque<>();
        while (curNode != null) {
            stack.addLast(curNode.val);
            curNode = curNode.next;
        }

        int res = 0;
        int base = 1;
        while (!stack.isEmpty()) {
            res += base * stack.removeLast();
            base *= 2;
        }
        return res;
    }
}