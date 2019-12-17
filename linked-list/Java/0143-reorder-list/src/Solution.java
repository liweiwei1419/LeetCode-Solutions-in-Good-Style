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
            s.append(cur.val + " -> ");
            cur = cur.next;
        }
        s.append("NULL");
        return s.toString();
    }
}

public class Solution {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        // 先找到中点
        ListNode n1 = head;
        ListNode n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        // 此时 n1 的位置就在中点，即分成 [0,n1] [n1+1,end]

        ListNode curNode = n1.next;
        n1.next = null;
        // 翻转链表

        ListNode pre = null;
        ListNode next;
        while (curNode != null) {
            next = curNode.next;
            curNode.next = pre;
            pre = curNode;
            curNode = next;
        }
        // 此时 pre 是翻转以后的链表头

        ListNode p1 = head;
        ListNode p2 = pre;

        while (p1 != null && p2 != null) {
            n1 = p1.next;
            n2 = p2.next;
            p1.next = p2;
            if (n1 == null) {
                break;
            }
            p2.next = n1;
            p1 = n1;
            p2 = n2;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        Solution solution = new Solution();
        ListNode head = new ListNode(nums);
        solution.reorderList(head);
        System.out.println(head);
    }
}
