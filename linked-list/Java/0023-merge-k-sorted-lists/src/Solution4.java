class Solution4 {

    // 同 Solution3 分治思想

    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        return mergeKLists(lists, 0, len - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int l, int r) {
        if (l >= r) {
            return lists[l];
        }
        int mid = l + (r - l) / 2;
        ListNode listNode1 = mergeKLists(lists, l, mid);
        ListNode listNode2 = mergeKLists(lists, mid + 1, r);
        return mergeTwoSortedListNode(listNode1, listNode2);
    }

    private ListNode mergeTwoSortedListNode(ListNode listNode1, ListNode listNode2) {
        // 先处理递归到底的情况
        if (listNode1 == null) {
            return listNode2;
        }
        if (listNode2 == null) {
            return listNode1;
        }
        if (listNode1.val < listNode2.val) {
            // 把问题转化为一个更小的问题
            listNode1.next = mergeTwoSortedListNode(listNode1.next, listNode2);
            return listNode1;
        } else {
            // 把问题转化为一个更小的问题
            listNode2.next = mergeTwoSortedListNode(listNode1, listNode2.next);
            return listNode2;
        }
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
        Solution4 solution4 = new Solution4();
        ListNode mergeKLists = solution4.mergeKLists(lists);
        System.out.println(mergeKLists);
    }
}