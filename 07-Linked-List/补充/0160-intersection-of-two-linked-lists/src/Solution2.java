/**
 * @author liwei
 * @date 2019/8/14 11:52 AM
 */
public class Solution2 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 特判
        if (headA == null || headB == null) {
            return null;
        }

        ListNode head1 = headA;
        ListNode head2 = headB;

        while (head1 != head2) {
            if (head1 != null) {
                head1 = head1.next;
            } else {
                head1 = headB;
            }

            if (head2 != null) {
                head2 = head2.next;
            } else {
                head2 = headA;
            }
        }
        return head1;
    }
}
