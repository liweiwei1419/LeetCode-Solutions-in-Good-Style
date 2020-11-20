public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 特判
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode curNode = dummyNode;

        // carry 是进位的意思，一开始不进位
        int carry = 0;

        // 注意：这里是或者
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            curNode.next = new ListNode(carry % 10);
            carry /= 10;
            curNode = curNode.next;
        }
        if (carry == 1) {
            curNode.next = new ListNode(1);
        }
        return dummyNode.next;
    }
}