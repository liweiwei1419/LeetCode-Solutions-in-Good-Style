public class Solution {

    // 方法一：穿针引线

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 这里设置 dummyNode 是为了处理头结点的特殊情况
        // 使得头结点和非头结点可以统一处理
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode curNode = dummyNode;

        while (curNode.next != null && curNode.next.next != null) {
            // 重新初始化 p1 和 p2
            ListNode p1 = curNode.next;
            ListNode p2 = p1.next;

            // 穿针引线的步骤就 3 步
            p1.next = p2.next;
            p2.next = p1;
            curNode.next = p2;

            // 循环变量更新
            curNode = p1;
        }
        return dummyNode.next;
    }
}