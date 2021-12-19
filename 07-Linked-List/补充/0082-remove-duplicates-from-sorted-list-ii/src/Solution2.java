public class Solution2 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        // 这里我们要清楚，例如 1 1 2 3 ,头结点也是有可能被删除的，所以要设置虚拟头结点
        // 只要涉及头结点的操作，我们都设立虚拟头结点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode curNode = dummyNode;
        // 题目要求的删除结点这个操作是站在被删除结点前面的
        // 所以循环可以继续的条件应该这样写
        while (curNode.next != null && curNode.next.next != null) {
            // 如果接连两个结点的 val 相等，至少要把它们都删掉
            if (curNode.next.val == curNode.next.next.val) {
                // 要删除的起点至少应该是当前判断相同的结点的第 2 个
                ListNode delNode = curNode.next.next;
                // 如果后面还有相同的结点，delNode 后移一位，即 delNode 应该是指向相同的结点的最后一个
                // 注意：这里得用循环，例如： 1 2 2 2 2 2 2 2 2 3 3 3
                // 得让 delNode 结点挪到最后一个 2 上
                while (delNode.next != null && delNode.next.val == delNode.val) {
                    delNode = delNode.next;
                }

                // 接下来把有重复的链表段删除就可以了
                // 1        2   2   2         3
                // curNode          delNode
                curNode.next = delNode.next;
                delNode.next = null;
            } else {
                // 否则向前走一步
                curNode = curNode.next;
            }
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 3, 3, 4, 4, 5, 6, 7, 8, 8, 8, 9};
        ListNode head = new ListNode(nums);
        Solution2 solution2 = new Solution2();
        ListNode deleteDuplicates = solution2.deleteDuplicates(head);
        System.out.println(deleteDuplicates);
    }
}
