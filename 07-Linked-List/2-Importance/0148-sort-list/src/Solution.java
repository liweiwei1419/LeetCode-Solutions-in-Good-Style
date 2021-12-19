public class Solution {

    // 递归方法不符合题目空间复杂度 O(1) 要求，但是是常规解法

    public ListNode sortList(ListNode head) {
        // 递归终止的条件，即满足下面条件就不用找中点，可以直接返回
        if (head == null || head.next == null) {
            return head;
        }
        // 使用归并排序、分治思想，先要找到链表的中间结点
        ListNode fast = head;
        ListNode slow = head;
        // 下面这段代码是找链表中间结点的一般做法
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 定义位于中间结点的下一个结点，从它那里将一个链表切开
        ListNode midNext = slow.next;
        // 这里一定要记得从中间切开，分割成两个链表
        slow.next = null;
        ListNode listNodeLeft = sortList(head);
        ListNode listNodeRight = sortList(midNext);
        // 合并两个已经排序的单链表，这是我们很熟悉的操作了
        return mergeOfTwoSortListNode(listNodeLeft, listNodeRight);
    }

    private ListNode mergeOfTwoSortListNode(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeOfTwoSortListNode(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeOfTwoSortListNode(l1, l2.next);
            return l2;
        }
    }
}