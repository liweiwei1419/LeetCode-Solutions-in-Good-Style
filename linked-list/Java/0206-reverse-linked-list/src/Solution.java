class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("数组不能为空");
        }
        this.val = arr[0];
        ListNode curr = this;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
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
    public ListNode reverseList(ListNode head) {
        // 特判
        if (head == null || head.next == null) {
            return head;
        }

        // 初始化上一个指针
        ListNode preNode = null;
        // 初始化当前指针
        ListNode curNode = head;
        while (curNode != null) {
            // 第 1 步：先把下一轮的循环变量保存一下，为了第 3 步方便
            ListNode nextNode = curNode.next;
            // 第 2 步：实现当前节点的 nextNode 指针的反转
            curNode.next = preNode;
            // 第 3 步：更新下一轮迭代的循环变量
            preNode = curNode;
            curNode = nextNode;
            // System.out.println(preNode);
        }
        // 遍历完成以后，原来的最后一个节点就成为了 preNode
        // 这个 preNode 就是反转以后的新的链表的头指针
        return preNode;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        Solution solution = new Solution();
        ListNode reverseList = solution.reverseList(head);
        System.out.println("反转之后");
        System.out.println(reverseList);
    }
}