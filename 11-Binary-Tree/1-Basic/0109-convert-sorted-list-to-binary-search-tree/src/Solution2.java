public class Solution2 {

    public TreeNode sortedListToBST(ListNode head) {
        // 特判：当结点为空，或者单结点的时候的简单逻辑
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        // 设置 pre 指针是为了切断单链表 mid 的前半部分
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;

        // 如果写 while fast and fast.next: 后面的代码稍有不同
        while (fast.next != null && fast.next.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // 此时 slow 结点就位于链表的中部，
        // 它的值就作为 BST 的根结点返回
        TreeNode root = new TreeNode(slow.val);
        // 因为要传入下一个递归方法，所以得先保存索引
        ListNode newHead = slow.next;
        slow.next = null;

        // 当链表只有 2 个结点的时候，pre 指针此时为 null，不用递归构造左子树
        if (pre != null) {
            pre.next = null;
            root.left = sortedListToBST(head);
        }
        root.right = sortedListToBST(newHead);
        return root;
    }
}