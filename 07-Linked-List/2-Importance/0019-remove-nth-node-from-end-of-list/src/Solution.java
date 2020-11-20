public class Solution {

    /**
     * 快慢指针：给定的 n 保证是有效的。
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        // 来到倒数第 N + 1 个结点的位置
        // 快指针先走 N 步
        ListNode fastNode = dummyNode;
        for (int i = 0; i < n; i++) {
            fastNode = fastNode.next;
        }

        ListNode slowNode = dummyNode;
        while (fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }

        // 此时 slowNode 来到了待删除的结点的上一个结点
        ListNode deleteNode = slowNode.next;
        slowNode.next = deleteNode.next;
        deleteNode.next = null;
        return dummyNode.next;
    }
}