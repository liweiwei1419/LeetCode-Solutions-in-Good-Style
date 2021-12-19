public class Solution2 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddHead = head;
        ListNode evenHead = head.next;

        ListNode oddCur = oddHead;
        ListNode evenCur = evenHead;
        // 执行循环的条件不能写错
        while (evenCur != null && evenCur.next != null) {
            oddCur.next = oddCur.next.next;
            evenCur.next = evenCur.next.next;

            oddCur = oddCur.next;
            evenCur = evenCur.next;
        }
        oddCur.next = evenHead;
        return oddHead;
    }
}
