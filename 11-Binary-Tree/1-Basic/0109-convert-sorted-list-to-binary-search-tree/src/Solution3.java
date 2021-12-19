public class Solution3 {

    // 个人觉得比较好的处理方案：把极端情况也考虑进去了
    // 1 -> 2 -> 3 -> 4

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        // slowNode 一次前进一格，fastNode 前进两格，pre 是 slowNode 前一个
        ListNode slowNode = head.next;
        ListNode fastNode = head.next.next;
        ListNode pre = head;
        while (fastNode != null && fastNode.next != null) {
            pre = pre.next;
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        pre.next = null;

        TreeNode root = new TreeNode(slowNode.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slowNode.next);
        return root;
    }
}