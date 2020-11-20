import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 题目说输入是两个非空链表，因此不用做非空判断

        // 为了保证从低位开始计算，因此使用两个栈
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();

        while (l1 != null) {
            stack1.addLast(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.addLast(l2.val);
            l2 = l2.next;
        }

        ListNode curHead = null;

        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) {
                carry += stack1.removeLast();
            }
            if (!stack2.isEmpty()) {
                carry += stack2.removeLast();
            }

            // 头插法
            ListNode newHead = new ListNode(carry % 10);
            newHead.next = curHead;
            curHead = newHead;
            carry /= 10;
        }

        if (carry == 1) {
            ListNode head = new ListNode(carry);
            head.next = curHead;
            return head;
        }
        return curHead;
    }
}