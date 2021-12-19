public class Solution2 {

    // 方法二：递归

    public ListNode reverseList(ListNode head) {
        // 特判
        if (head == null || head.next == null) {
            return head;
        }

        ListNode nextNode = head.next;
        ListNode newNode = reverseList(nextNode);
        nextNode.next = head;
        // 这里不要忘记切断引用，否则会出现错误：Error - Found cycle in the ListNode
        head.next = null;
        return newNode;
    }
}