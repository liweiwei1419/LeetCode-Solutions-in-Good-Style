class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int[] nums) {
        ListNode currNode = this;
        currNode.val = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currNode.next = new ListNode(nums[i]);
            currNode = currNode.next;
        }
    }

    @Override
    public String toString() {
        ListNode currNode = this;
        StringBuilder s = new StringBuilder();
        while (currNode != null) {
            s.append(currNode.val);
            s.append(" -> ");
            currNode = currNode.next;
        }
        s.append("NULL");
        return s.toString();
    }
}

// 分治法不符合要求：常数级空间复杂度

public class Solution {

    public ListNode sortList(ListNode head) {
        // 递归终止的条件，即满足下面条件就不用找中点，可以直接返回
        if (head == null || head.next == null) {
            return head;
        }
        // 使用归并排序、分治思想，先要找到链表的中间结点
        ListNode fast = head;
        ListNode slow = head;
        // 下面这段代码是找链表中间结点的一般做法
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 定义位于中间结点的下一个结点，从它那里将一个链表切开
        ListNode midNext = slow.next;
        // 这里一定要记得从中间切开，分割成两个链表
        slow.next = null;
        ListNode listNodeLeft = sortList(head);
        ListNode listNodeRight = sortList(midNext);
        // 合并两个已经排序的单链表，这是我们很熟悉的操作了
        return mergeOfTwoSortListNode(listNodeLeft, listNodeRight);
    }

    private ListNode mergeOfTwoSortListNode(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeOfTwoSortListNode(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeOfTwoSortListNode(l1, l2.next);
            return l2;
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{12, 10, 8, 9, 6, 5, 4, 3};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        Solution solution = new Solution();
        ListNode sortList = solution.sortList(head);
        System.out.println(sortList);
    }
}
