import java.util.HashSet;
import java.util.Set;

public class Solution3 {


    /**
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> hashSet = new HashSet<>();

        ListNode curNode = headA;
        while (curNode != null) {
            hashSet.add(curNode);
            curNode = curNode.next;
        }

        curNode = headB;
        while (curNode != null) {
            if(hashSet.contains(curNode)){
                return curNode;
            }
            curNode = curNode.next;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(null == null);
    }
}
