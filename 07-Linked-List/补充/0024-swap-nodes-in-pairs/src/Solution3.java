public class Solution3 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        // 没有必要这么写
        p2.next = swapPairs(p2.next);
        p1.next = p2.next;
        p2.next = p1;
        return p2;
    }
    public static void main(String[] args) {
        // 给定 1->2->3->4, 你应该返回 2->1->4->3.
        int[] nums = {1, 2, 3, 4};
        ListNode head = new ListNode(nums);
        Solution3 solution2 = new Solution3();
        ListNode swapPairs = solution2.swapPairs(head);
        System.out.println(swapPairs);
    }
}
