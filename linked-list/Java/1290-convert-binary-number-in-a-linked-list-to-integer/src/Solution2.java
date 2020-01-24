
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

    public static void main(String[] args) {
        // int[] arr = {1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0};
        int[] arr = {1, 0, 1};
        ListNode head = new ListNode(arr);
        Solution2 solution2 = new Solution2();
        int res = solution2.getDecimalValue(head);
        System.out.println(res);
    }
}
