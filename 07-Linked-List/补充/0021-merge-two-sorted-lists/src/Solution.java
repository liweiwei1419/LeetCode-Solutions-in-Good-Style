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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode curNode = dummyNode;
        // 两者都不为空的时候，才有必要进行比较
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                // 指针修改发生在这里
                curNode.next = p1;
                p1 = p1.next;
            } else {
                // 指针修改发生在这里
                curNode.next = p2;
                p2 = p2.next;
            }
            curNode = curNode.next;
        }
        // 跳出循环是因为 p1 == null 或者 p2 == null
        if (p1 == null) {
            curNode.next = p2;
        }
        if (p2 == null) {
            curNode.next = p1;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4, 6};

        ListNode l1 = new ListNode(nums1);
        ListNode l2 = new ListNode(nums2);

        Solution solution = new Solution();
        ListNode mergeTwoLists = solution.mergeTwoLists(l1, l2);
        System.out.println(mergeTwoLists);
    }
}
