public class Solution4 {

    // 快慢指针

    public boolean hasCycle(ListNode head) {
        // 特判
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        // 慢指针一次走一步、快指针一次走两步
        // 注意：快指针可以走的条件 fast != null && fast.next != null

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}