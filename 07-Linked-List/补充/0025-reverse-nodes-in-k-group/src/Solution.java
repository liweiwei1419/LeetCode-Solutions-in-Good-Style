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

    public ListNode reverseKGroup(ListNode head, int k) {
        // 使用递归写法的话，先考虑特殊情况
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        // 探测长度的结点
        ListNode tempNode = head;
        int curk = k;
        while (tempNode != null && curk != 0) {
            curk--;
            tempNode = tempNode.next;
        }
        // 如果够数了，先考虑反转
        if (curk == 0) {
            // 下面开始反转
            ListNode pre = null;
            ListNode curNode = head;
            for (int i = 0; i < k; i++) {
                ListNode nextNode = curNode.next;
                curNode.next = pre;
                pre = curNode;
                curNode = nextNode;
            }
            head.next = reverseKGroup(tempNode, k);
            return pre;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2};
        ListNode head = new ListNode(nums);
        Solution solution = new Solution();
        ListNode reverseKGroup = solution.reverseKGroup(head, 2);
        System.out.println(reverseKGroup);
    }
}