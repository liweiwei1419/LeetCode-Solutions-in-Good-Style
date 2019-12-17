class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("arr can not be empty");
        }
        this.val = nums[0];
        ListNode curr = this;
        for (int i = 1; i < nums.length; i++) {
            curr.next = new ListNode(nums[i]);
            curr = curr.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            s.append(cur.val);
            s.append(" -> ");
            cur = cur.next;
        }
        s.append("NULL");
        return s.toString();
    }
}

/**
 * @author liweiwei1419
 */
public class Solution {

    // 利用第 206 题：穿针引线，使用 4 个指针变量

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 因为有头结点有可能发生变化，使用虚拟头结点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode p1 = dummyNode;
        // 第 1 步：从虚拟头结点走 m - 1 步，来到 m 结点的前一个结点
        // 建议写在 for 循环里，语义清晰
        for (int i = 0; i < m - 1; i++) {
            p1 = p1.next;
        }

        // 第 2 步：从 p1 再走 n - m + 1 步，来到 n 结点
        ListNode p2 = p1;
        for (int i = 0; i < n - m + 1; i++) {
            p2 = p2.next;
        }

        // 第 3 步：切断出一个子链表（截取链表）
        ListNode p3 = p1.next;
        ListNode p4 = p2.next;

        p1.next = null;
        p2.next = null;

        // 第 4 步：反转子链表
        reverseLinkedList(p3);

        // 第 5 步：接回到原来的链表中
        p1.next = p2;
        p3.next = p4;
        return dummyNode.next;

    }

    private void reverseLinkedList(ListNode head) {
        // 也可以使用递归反转一个链表
        ListNode pre = null;
        ListNode cur = head;
        // 在循环开始之前声明，可以避免在循环中反复声明新变量
        ListNode next;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}
