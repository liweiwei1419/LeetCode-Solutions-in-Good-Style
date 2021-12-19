public class Solution2 {

    // 方法二：递归

    public ListNode swapPairs(ListNode head) {
        // 特判
        if (head == null || head.next == null) {
            return head;
        }

        // 没有必要设置虚拟头结点了
        ListNode p1 = head;
        ListNode p2 = head.next;

        p1.next = swapPairs(p2.next);
        p2.next = p1;
        return p2;
    }
}