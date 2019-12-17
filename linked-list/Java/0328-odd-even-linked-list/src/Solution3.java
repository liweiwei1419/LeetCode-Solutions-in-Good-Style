public class Solution3 {

    // 思路也很简单，分别创建两个链表，根据条件接在相应的链表后面
    // 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性

    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(-1);
        ListNode evenHead = new ListNode(-1);
        ListNode oddCurr = oddHead;
        ListNode evenCurr = evenHead;
        int count = 0;
        ListNode curr;
        while (head != null) {
            count++;
            curr = new ListNode(head.val);
            if (count % 2 == 0) {
                evenCurr.next = curr;
                evenCurr = evenCurr.next;
            } else {
                oddCurr.next = curr;
                oddCurr = oddCurr.next;
            }
            head = head.next;
        }
        oddCurr.next = evenHead.next;
        return oddHead.next;
    }
}
