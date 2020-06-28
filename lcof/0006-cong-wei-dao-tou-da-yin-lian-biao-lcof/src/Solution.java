import java.util.ArrayDeque;
import java.util.Deque;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        // Java 在 Stack 类的文档里建议使用 Deque
        Deque<Integer> stack = new ArrayDeque<>();
        ListNode curNode = head;
        while (curNode != null) {
            stack.addLast(curNode.val);
            curNode = curNode.next;
        }


        int size = stack.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            // 这里因为提前读取了 size，因此在 stack 发送 pop 的时候，
            // 不必检测 stack 是否为空
            res[i] = stack.removeLast();
        }
        return res;
    }
}