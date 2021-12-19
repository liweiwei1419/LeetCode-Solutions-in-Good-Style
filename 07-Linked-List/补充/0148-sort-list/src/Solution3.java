public class Solution3 {

    // 参考：https://leetcode-cn.com/problems/sort-list/solution/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/

    public ListNode sortList(ListNode head) {
        int len = getLenOfListNode(head);

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode cur;
        ListNode tail;
        ListNode left;
        ListNode right;

        for (int sz = 1; sz < len; sz += sz) {
            cur = dummyNode.next;
            // tail 一开始也是指向虚拟结点的，全局用一个就好
            // 每次重复用这个 dummy 结点
            tail = dummyNode;

            while (cur != null) {
                left = cur;
                right = cut(left, sz);
                cur = cut(right, sz);

                // tail 一直都指向排序链表的尾部
                tail.next = mergeTwoLists(left, right);
                // 然后把 tail 一直放在最后
                while (tail.next != null) {
                    tail = tail.next;
                }
            }
        }
        return dummyNode.next;
    }

    private ListNode cut(ListNode head, int n) {
        // 切下链表的头 n 个结点，返回剩下的链表的头结点
        ListNode cur = head;
        // 向前走 n - 1 步，然后切断链表
        for (int i = 0; i < n - 1 && cur != null; i++) {
            cur = cur.next;
        }
        if (cur == null) {
            return null;
        }
        ListNode next = cur.next;
        // 切断链接
        cur.next = null;
        return next;
    }

    private int getLenOfListNode(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

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