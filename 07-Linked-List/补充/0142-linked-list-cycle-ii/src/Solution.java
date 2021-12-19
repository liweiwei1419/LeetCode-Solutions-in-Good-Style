class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
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

    public ListNode detectCycle(ListNode head) {
        // 特判
        if (head == null || head.next == null) {
            // 注意：不要习惯性把 head 返回回去
            return null;
        }

        // 起点要一样，这里利用第 141 题的结论
        ListNode slow = head;
        ListNode fast = head;

        // 注意这种写法，因为快指针一次走两步，
        // 所以要看它下一个结点以及下下一个结点是否为空
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        // 特判，如果只是因为链表不存在环，那就返回空，因为既然不存在环，肯定没有重复结点
        if (fast.next == null || fast.next.next == null) {
            return null;
        }

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
