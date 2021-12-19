public class Solution4 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode newHead = dummy;
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            newHead.next = second;
            first.next = second.next;
            second.next = first;

            newHead = first;
            head = first.next;
        }
        return dummy.next;
    }
}
