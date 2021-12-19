public class Solution2 {

    // 递归

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        // 假设小一个规模的问题已经解决
        head.next = removeElements(head.next, val);
        if (head.val == val) {
            return head.next;
        } else {
            return head;
        }
    }

    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }


    // 这是一个递归方法，首先处理递归到底的情况

    public ListNode removeElements3(ListNode head, int val) {
        // 首先处理递归到底的情况
        if (head == null) {
            return head;
        }
        // 把一个问题转化为规模更小的问题
        ListNode res = removeElements(head.next, val);
        // 下面处理原始规模的问题如何与小规模的问题建立联系
        if (head.val == val) {
            // 当前这个节点必须要被删掉
            return res;
        } else {
            head.next = res;
            return head;
        }
    }
}
