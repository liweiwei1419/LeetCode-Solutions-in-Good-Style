public class Solution2 {

    public int getDecimalValue(ListNode head) {
        ListNode curNode = head;
        int res = 0;

        while (curNode != null) {
            res = res * 2 + curNode.val;
            curNode = curNode.next;
        }
        return res;
    }
}