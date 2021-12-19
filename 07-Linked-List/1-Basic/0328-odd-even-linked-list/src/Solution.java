public class Solution {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyNodeOdd = new ListNode(-1);
        ListNode dummyNodeEven = new ListNode(-1);
        ListNode curOdd = dummyNodeOdd;
        ListNode curEven = dummyNodeEven;
        int count = 0;
        while (head != null) {
            if ((count % 2) == 0) {
                curOdd.next = head;
                curOdd = curOdd.next;
            } else {
                curEven.next = head;
                curEven = curEven.next;
            }
            head = head.next;
            count++;
        }
        curOdd.next = dummyNodeEven.next;
        // 特别注意：最后这一步不能忘记，否则会产生一个循环链表
        curEven.next = null;
        return dummyNodeOdd.next;
    }
}