public class Solution2 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode curNode = head;
        // 当前和下一个结点都非空的时候才删除
        while (curNode != null && curNode.next != null) {
            // 值相同的时候考虑删除
            if (curNode.val == curNode.next.val) {
                ListNode deleteNode = curNode.next;
                // 看看是否还可以删除
                while (deleteNode.next != null && deleteNode.val == deleteNode.next.val) {
                    deleteNode = deleteNode.next;
                }
                // 穿针引线
                curNode.next = deleteNode.next;
                deleteNode.next = null;
            } else {
                curNode = curNode.next;
            }
        }
        return head;
    }
}