import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("arr can not be empty");
        }
        this.val = nums[0];
        ListNode curr = this;
        for (int i = 1; i < nums.length; i++) {
            curr.next = new ListNode(nums[i]);
            curr = curr.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            s.append(cur.val);
            s.append(" -> ");
            cur = cur.next;
        }
        s.append("NULL");
        return s.toString();
    }
}

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 特判
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // 为了保证从低位开始计算，因此使用两个栈
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode nextNode = null;
        ListNode curNode;

        int carry = 0;
        while (!stack1.empty() || !stack2.empty()) {
            if (!stack1.empty()) {
                carry += stack1.pop();
            }
            if (!stack2.empty()) {
                carry += stack2.pop();
            }

            // 头插法
            curNode = new ListNode(carry % 10);
            curNode.next = nextNode;
            nextNode = curNode;
            carry /= 10;
        }
        if (carry == 1) {
            ListNode head = new ListNode(carry);
            head.next = nextNode;
            return head;
        }
        return nextNode;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {7, 2, 4, 3};
        int[] nums2 = {5, 6, 4};
        ListNode head1 = new ListNode(nums1);
        ListNode head2 = new ListNode(nums2);
        ListNode addTwoNumbers = solution.addTwoNumbers(head1, head2);
        System.out.println(addTwoNumbers);
    }
}
