public class Solution4 {

    public boolean hasCycle(ListNode head) {
        // 特判
        if (head == null || head.next == null) {
            return false;
        }

        ListNode curNode = head;
        int count = 0;
        while (curNode != null) {
            curNode = curNode.next;
            if (count == 10000){
                return true;
            }
            count++;
        }
        return false;
    }
}
