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

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 这里设置 dummyNode 是为了处理头结点的特殊情况
        // 使得头结点和非头结点可以统一处理
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode curNode = dummyNode;

        while (curNode.next != null && curNode.next.next != null) {
            // 重新初始化 p1 和 p2
            ListNode p1 = curNode.next;
            ListNode p2 = p1.next;

            // 穿针引线的步骤就 3 步
            p1.next = p2.next;
            p2.next = p1;
            curNode.next = p2;

            // 循环变量更新
            curNode = p1;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        // 给定 1->2->3->4, 你应该返回 2->1->4->3.
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(nums);
        Solution solution = new Solution();
        ListNode swapPairs = solution.swapPairs(head);
        System.out.println(swapPairs);
    }
}



