public class Solution3 {

    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        return mergeKLists(lists, 0, len - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int left, int right) {
        // 根据下文对 mergeKLists 的递归调用情况，区间最窄的时候，只可能是左右端点重合的时候
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode list1 = mergeKLists(lists, left, mid);
        ListNode list2 = mergeKLists(lists, mid + 1, right);
        return mergeTwoSortLinkedList(list1, list2);
    }

    private ListNode mergeTwoSortLinkedList(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoSortLinkedList(list1.next, list2);
            return list1;
        }
        list2.next = mergeTwoSortLinkedList(list1, list2.next);
        return list2;
    }
}