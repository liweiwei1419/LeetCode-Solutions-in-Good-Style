public class Solution2 {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode anotherHead = slow.next;
        // 步骤1：从中间截断链表
        slow.next = null;
        // 步骤2：反转链表的后半截
        ListNode reverseList = reverseList(anotherHead);
        // 步骤3：合并两个链表
        int k = 0;
        mergeTwoList(head, reverseList, k);
    }

    private ListNode mergeTwoList(ListNode head1, ListNode head2, int k) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        // k % 2 == 0
        if ((k & 1) == 0) {
            head1.next = mergeTwoList(head1.next, head2, ++k);
            return head1;
        } else {
            head2.next = mergeTwoList(head1, head2.next, ++k);
            return head2;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        ListNode curNode = head;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }
}