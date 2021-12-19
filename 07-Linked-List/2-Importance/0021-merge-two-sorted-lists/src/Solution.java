public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode curNode = dummyNode;
        // 两者都不为空的时候，才有必要进行比较
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                // 指针修改发生在这里
                curNode.next = p1;
                p1 = p1.next;
            } else {
                // 指针修改发生在这里
                curNode.next = p2;
                p2 = p2.next;
            }
            curNode = curNode.next;
        }
        // 跳出循环是因为 p1 == null 或者 p2 == null
        if (p1 == null) {
            curNode.next = p2;
        }
        if (p2 == null) {
            curNode.next = p1;
        }
        return dummyNode.next;
    }
}