import java.util.HashSet;
import java.util.Set;

public class Solution2 {

    public boolean hasCycle(ListNode head) {
        // 特判
        if (head == null || head.next == null) {
            return false;
        }

        ListNode curNode = head;
        Set<ListNode> hashSet = new HashSet<>();
        while (curNode != null) {
            if (hashSet.contains(curNode)) {
                return true;
            }
            hashSet.add(curNode);
            curNode = curNode.next;
        }
        return false;
    }
}