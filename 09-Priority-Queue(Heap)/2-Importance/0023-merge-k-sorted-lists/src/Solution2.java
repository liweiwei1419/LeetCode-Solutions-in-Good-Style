public class Solution2 {

    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }

        ListNode res = lists[0];
        for (int i = 1; i < len; i++) {
            if (lists[i] != null) {
                res = mergeTwoSortLinkedList(res, lists[i]);
            }
        }
        return res;
    }

    private ListNode mergeTwoSortLinkedList(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode curNode = dummyNode;
        // 两者都不为空的时候，才有必要进行比较
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                curNode.next = p1;
                p1 = p1.next;
            } else {
                curNode.next = p2;
                p2 = p2.next;
            }
            curNode = curNode.next;
        }
        // 跳出循环是因为 p1 == null 或者 p2 == null
        if (p1 == null) {
            curNode.next = p2;
        } else {
            curNode.next = p1;
        }
        return dummyNode.next;
    }
}