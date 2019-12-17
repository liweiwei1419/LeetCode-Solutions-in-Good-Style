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

    public ListNode insertionSortList(ListNode head) {
        ListNode dummyNode = new ListNode(-1);

        ListNode curNode = head;
        while (curNode != null) {
            // 第 1 步：先把下一个结点存一下，下一次遍历就从 nextNode 开始
            ListNode nextNode = curNode.next;

            // 第 2 步：需要找到要插入的位置的前一个结点的位置，这需要从前向后找，这一点非常不一样
            // 每一次 preNode 都得从头开始
            ListNode preNode = dummyNode;

            // 因为有 preNode.next ，所以应该先判断非空
            while (preNode.next != null && preNode.next.val < curNode.val) {
                // 严格小于就可以了，没有必要移到小于等于的最后一个，不用保证稳定性
                preNode = preNode.next;
            }
            // 退出循环的时候，preNode.next.val >= curNode.val
            // 第 3 步：穿针引线
            curNode.next = preNode.next;
            preNode.next = curNode;

            // 第 4 步：循环变量更新
            curNode = nextNode;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 7, 9, 10, 8};
        ListNode head = new ListNode(nums);
        Solution solution = new Solution();
        ListNode insertionSortList = solution.insertionSortList(head);
        System.out.println(insertionSortList);
    }
}
