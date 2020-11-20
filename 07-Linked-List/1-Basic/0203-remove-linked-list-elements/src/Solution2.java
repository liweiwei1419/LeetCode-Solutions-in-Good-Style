public class Solution2 {

    // 递归

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        // 假设小一个规模的问题已经解决
        head.next = removeElements(head.next, val);
        if (head.val == val) {
            return head.next;
        } else {
            return head;
        }
    }
}