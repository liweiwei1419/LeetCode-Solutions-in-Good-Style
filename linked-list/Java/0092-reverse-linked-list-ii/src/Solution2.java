public class Solution2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 创建一个虚拟的节点（dummy）
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        int k = 0;
        while (++k < m) {
            if (pre != null) {
                pre = pre.next;
            }
        }
        // tail 是尾巴的意思
        ListNode tail = pre.next;
        while (++k <= n) {
            ListNode temp = pre.next;
            pre.next = tail.next;
            tail.next = tail.next.next;
            pre.next.next = temp;
        }
        return dummy.next;
    }
}
