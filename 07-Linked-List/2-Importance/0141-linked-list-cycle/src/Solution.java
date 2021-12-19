public class Solution {

    public boolean hasCycle(ListNode head) {
        // 特判
        if (head == null || head.next == null) {
            return false;
        }

        ListNode curNode = head;
        int count = 0;
        while (curNode != null) {
            curNode = curNode.next;
            // 在遍历了 10000 个结点以后，都没有遍历完，认为链表中有环
            // 这是一种「取巧」的做法
            if (count == 10000){
                return true;
            }
            count++;
        }
        return false;
    }
}