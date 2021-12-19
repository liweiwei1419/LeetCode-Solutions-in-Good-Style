public class Solution2 {

    public ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        if (size == 0) {
            return null;
        }

        ListNode res = lists[0];
        for (int i = 1; i < size; i++) {
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

    public static void main(String[] args) {
        Integer[] nums1 = {1, 4, 5};
        Integer[] nums2 = {1, 3, 4};
        Integer[] nums3 = {2, 6};
        ListNode head1 = new ListNode(nums1);
        ListNode head2 = new ListNode(nums2);
        ListNode head3 = new ListNode(nums3);
        ListNode[] lists = new ListNode[3];
        lists[0] = head1;
        lists[1] = head2;
        lists[2] = head3;
        Solution2 solution2 = new Solution2();
        ListNode mergeKLists = solution2.mergeKLists(lists);
        System.out.println(mergeKLists);
    }
}
