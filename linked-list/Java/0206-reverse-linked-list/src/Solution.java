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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode preNode = null;
        ListNode curNode = head;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        Solution solution = new Solution();
        ListNode reverseList = solution.reverseList(head);
        System.out.println("反转之后");
        System.out.println(reverseList);
    }
}