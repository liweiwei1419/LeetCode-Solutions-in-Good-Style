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
            s.append(cur.val ).append(" -> ");
            cur = cur.next;
        }
        s.append("NULL");
        return s.toString();
    }
}


// 关键在于边界条件的讨论，和代码调试

public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        // 特判
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 第 1 步：先要知道链表有多少个结点
        int n = 1;
        ListNode fastNode = head;
        while (fastNode.next != null) {
            fastNode = fastNode.next;
            n++;
        }
        // 此时 fastNode 到末尾结点

        k = k % n;
        if (k == 0) {
            return head;
        }
        // 第 2 步：找到倒数第 k 个结点，走 n - k - 1 步
        ListNode slowNode = head;
        for (int i = 0; i < n - k - 1; i++) {
            slowNode = slowNode.next;
        }

        // 第 3 步：穿针引线
        ListNode newHead = slowNode.next;
        // 先把尾部接到开头
        fastNode.next = head;
        // 再切断原来的连接
        slowNode.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int k = 2;
        ListNode head = new ListNode(nums);
        Solution solution = new Solution();
        ListNode newNode = solution.rotateRight(head, k);
        System.out.println(newNode);
    }
}