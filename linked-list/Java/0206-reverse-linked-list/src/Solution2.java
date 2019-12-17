/**
 * @author liwei
 * @date 2019/8/14 5:35 AM
 */
public class Solution2 {

    public ListNode reverseList(ListNode head) {
        // 特判
        if (head == null || head.next == null) {
            return head;
        }

        ListNode nextNode = head.next;
        ListNode newHead = reverseList(nextNode);
        nextNode.next = head;
        head.next = null;
        // System.out.println(newHead);
        return newHead;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head2 = new ListNode(nums);
        System.out.println(head2);
        Solution2 solution2 = new Solution2();
        ListNode reverseList = solution2.reverseList(head2);
        System.out.println("反转之后");
        System.out.println(reverseList);
    }
}
