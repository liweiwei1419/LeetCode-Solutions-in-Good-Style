public class Solution3 {

    public boolean isPalindrome(ListNode head) {
        // 特判
        if (head == null || head.next == null) {
            return true;
        }

        // 1、使用快慢指针找到链表的中间结点
        // 偶数个结点的时候，来到了中间靠左的那个结点
        ListNode slowNode = head;
        ListNode fastNode = head;

        while (fastNode.next != null && fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        // 2、slowNode 的下一个就是新链表，反转它
        ListNode curNode = slowNode.next;
        // 注意：这里要切点连接，否则反转的额时候会出问题
        slowNode.next = null;

        // 3、反转链表的后半部分
        ListNode pre = null;
        while (curNode != null) {
            ListNode next = curNode.next;
            curNode.next = pre;
            pre = curNode;
            curNode = next;
        }

        // 此时 pre 成为新链表的表头
        // 4、逐个比对，两边长度不一，但只要「前缀部分相等即可」
        while (head != null && pre != null) {
            if (head.val != pre.val) {
                return false;
            }
            head = head.next;
            pre = pre.next;
        }
        return true;
    }
}
