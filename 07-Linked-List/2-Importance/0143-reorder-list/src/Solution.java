public class Solution {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        // 第 1 步：先找到中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 此时 slow 的位置就在中点，即分成 [0, slow] [slow + 1,end]

        ListNode curNode = slow.next;
        slow.next = null;
        // 第 2 步：翻转链表
        ListNode pre = null;
        ListNode next;
        while (curNode != null) {
            next = curNode.next;
            curNode.next = pre;
            pre = curNode;
            curNode = next;
        }
        // 此时 pre 是翻转以后的链表头
        // 第 3 步：合并两个链表
        ListNode p1 = head;
        ListNode p2 = pre;

        while (p2 != null) {
            slow = p1.next;
            fast = p2.next;
            p1.next = p2;
            if (slow == null) {
                break;
            }
            p2.next = slow;
            p1 = slow;
            p2 = fast;
        }
    }
}