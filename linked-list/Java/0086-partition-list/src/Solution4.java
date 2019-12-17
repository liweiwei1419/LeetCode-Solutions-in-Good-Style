/**
 * 参考：http://blog.csdn.net/mnmlist/article/details/43535377
 */
public class Solution4 {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode littleStart = new ListNode(-1);
        ListNode littleEnd = littleStart;

        ListNode bigStart = new ListNode(-1);
        ListNode bigEnd = bigStart;

        // 头结点
        ListNode pListNode = head;
        while (pListNode != null) {
            if (pListNode.val < x) {
                littleEnd.next = pListNode;
                littleEnd = pListNode;
            } else {
                bigEnd.next = pListNode;
                bigEnd = pListNode;
            }
            pListNode = pListNode.next;
        }

        // 创建的 DummyNode 节点要向后挪动一位
        littleStart = littleStart.next;
        bigStart = bigStart.next;

        if (littleStart != null) {
            bigEnd.next = null;
            littleEnd.next = bigStart;
            return littleStart;
        } else {
            return bigStart;
        }
    }
}
