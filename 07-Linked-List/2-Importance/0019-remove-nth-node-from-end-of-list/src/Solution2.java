public class Solution2 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 先获得链表的长度
        int len = getLenOfNode(head);

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode curNode = dummyNode;
        // 从虚拟头结点开始走 len - n 步
        for (int i = 0; i < len - n; i++) {
            curNode = curNode.next;
        }

        // 删除结点，先声明待删除结点
        ListNode deleteNode = curNode.next;
        // 再修改指针指向
        curNode.next = deleteNode.next;
        // 删除结点的 next 指针释放引用
        deleteNode.next = null;
        return dummyNode.next;
    }


    private int getLenOfNode(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}