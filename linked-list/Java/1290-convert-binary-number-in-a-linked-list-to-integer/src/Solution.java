import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("数组不能为空");
        }
        this.val = arr[0];
        ListNode curr = this;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
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

    public int getDecimalValue(ListNode head) {
        ListNode curNode = head;
        Stack<Integer> stack = new Stack<>();
        while (curNode != null) {
            stack.push(curNode.val);
            curNode = curNode.next;
        }

        int res = 0;
        int base = 1;
        while (!stack.isEmpty()) {
            res += base * stack.pop();
            base *= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        // int[] arr = {1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0};
        int[] arr = {1, 0, 1};
        ListNode head = new ListNode(arr);
        Solution solution = new Solution();
        int res = solution.getDecimalValue(head);
        System.out.println(res);
    }
}
