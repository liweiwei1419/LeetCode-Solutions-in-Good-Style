public class Solution {

    // 方法一：穿针引线

    public ListNode reverseList(ListNode head) {
        // 特判
        if (head == null || head.next == null) {
            return head;
        }

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