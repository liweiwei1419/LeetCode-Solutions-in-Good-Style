/**
 * @author liweiwei1419
 */
public class Solution2 {

    public ListNode insertionSortList(ListNode head) {
        // 先写最特殊的情况
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode curNode = head;
        ListNode pre;
        ListNode next;
        while (true) {
            // 如果遍历下去，是顺序排列的话，那最简单了，curNode 指针向前就行了
            // 这一步是一个循环的过程
            // 暂存当前结点的下一结点
            while (curNode.next != null && curNode.val <= curNode.next.val) {
                curNode = curNode.next;
            }
            // 下面针对上一步跳出循环的两个条件进行特殊处理
            if (curNode.next == null) {
                // 如果后面没有元素了，那就说明，此时链表已经有序，可以结束我们的排序逻辑了
                break;
            } else {
                // 否则就一定满足 curNode.val > curNode.next.val; 为真
                // pre 打回到起点
                pre = dummyNode;
                next = curNode.next;
                // 把 pre 挪到可以放置 next 结点的上一个位置
                while (pre.next.val < next.val) {
                    pre = pre.next;
                }
                // 穿针引线的 3 个步骤，请见图 https://liweiwei1419.github.io/images/leetcode-solution/147-1.jpg
                // 穿针引线步骤 1
                curNode.next = next.next;
                // 穿针引线步骤 2
                next.next = pre.next;
                // 穿针引线步骤 2
                pre.next = next;
            }
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 7, 9, 10, 8};
        ListNode head = new ListNode(nums);
        Solution2 solution2 = new Solution2();
        ListNode insertionSortList = solution2.insertionSortList(head);
        System.out.println(insertionSortList);
    }
}
