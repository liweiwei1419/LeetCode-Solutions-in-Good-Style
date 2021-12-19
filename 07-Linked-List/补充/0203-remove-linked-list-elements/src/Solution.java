class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    // 下面，我们将 LeetCode 中的给出的链表的节点这个类进行一些扩展，方便我们的调试
    // 1、给出一个数字数组，通过数组构建数字链表

    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr can not be empty");
        }
        // 体会这里 this 指代了什么，其实就是 head
        // 因为这是一个构造函数，所以也无须将 head 返回
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    // 2、重写 toString() 方法，方便我们查看链表中的元素

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        // 还是要特别注意的是，理解这里 this 的用法
        ListNode cur = this;
        while (cur != null) {
            s.append(cur.val).append(" -> ");
            cur = cur.next;
        }
        s.append("NULL");
        return s.toString();
    }
}

public class Solution {

    // 穿针引线

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while (cur.next != null) {
            if (cur.next.val == val) {
                // 待删除的结点
                ListNode deleteNode = cur.next;
                cur.next = deleteNode.next;
                deleteNode.next = null;
            } else {
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        Solution solution = new Solution();
        solution.removeElements(head, 6);
        System.out.println(head);
    }
}
