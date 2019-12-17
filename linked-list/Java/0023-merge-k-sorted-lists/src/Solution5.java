class Solution5 {

    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        return mergeKLists(lists, 0, len - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        int mid = l + (r - l) / 2;
        ListNode listNodeLeft = mergeKLists(lists, l, mid);
        ListNode listNoderight = mergeKLists(lists, mid + 1, r);
        // 于是问题转化成合并两个有序链表的问题了，我们可以穿针引线，也可以继续递归解决这个子问题，请见 LeetCode 第 21 题，
        // 这里我们使用继续递归解决，
        // 因为使用穿针引线，每一次调用这个方法的时候，都需要创建一个虚拟的头结点，归并次数有些多的时候，是不划算的
        return mergeTwoSortedListNode(listNodeLeft, listNoderight);
    }

    private ListNode mergeTwoSortedListNode(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        if (node1.val < node2.val) {
            node1.next = mergeTwoSortedListNode(node1.next, node2);
            return node1;
        } else {
            node2.next = mergeTwoSortedListNode(node1, node2.next);
            return node2;
        }
    }
}