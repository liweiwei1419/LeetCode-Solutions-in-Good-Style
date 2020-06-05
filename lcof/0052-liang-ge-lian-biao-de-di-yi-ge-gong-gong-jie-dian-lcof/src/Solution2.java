import java.util.ArrayDeque;
import java.util.Deque;


public class Solution2 {

    public ListNode getIntersectionNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        Deque<ListNode> stack1 = new ArrayDeque<>();
        Deque<ListNode> stack2 = new ArrayDeque<>();
        ListNode curNode = pHead1;
        while (curNode != null) {
            stack1.addLast(curNode);
            curNode = curNode.next;
        }
        curNode = pHead2;
        while (curNode != null) {
            stack2.addLast(curNode);
            curNode = curNode.next;
        }

        ListNode res = null;
        // 因为是公共结点，所以他们的地址一定一样，可以用 ==
        while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peekLast() == stack2.peekLast()) {
            stack1.removeLast();
            res = stack2.removeLast();
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode phead1 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        phead1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode phead2 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        phead2.next = node7;
        node7.next = node4;


        Solution solution = new Solution();
        ListNode findFirstCommonNode2 = solution.getIntersectionNode(phead1, phead2);
        System.out.println(findFirstCommonNode2);
    }
}
