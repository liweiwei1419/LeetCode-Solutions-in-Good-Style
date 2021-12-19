import java.util.HashSet;
import java.util.Set;

public class Solution3 {

    public boolean hasCycle(ListNode head) {
        // 特判
        if (head == null || head.next == null) {
            return false;
        }

        Set<ListNode> hashSet = new HashSet<>();

        ListNode curNode = head;
        while (curNode != null) {
            if (hashSet.contains(curNode)) {
                return true;
            } else {
                hashSet.add(curNode);
            }
            curNode = curNode.next;
        }
        return false;
    }
}