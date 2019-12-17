public class Solution5 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode evenHead = evenNode;
        while (evenNode != null && evenNode.next != null) {
            oddNode.next = evenNode.next;
            oddNode = oddNode.next;
            evenNode.next = oddNode.next;
            evenNode = evenNode.next;
        }
        oddNode.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = createListNode(new int[]{1, 2, 3, 4, 5});
        Solution2 solution = new Solution2();
        ListNode result1 = solution.oddEvenList(node1);
        printLinkedList(result1);

        System.out.println("------");


        ListNode node2 = createListNode(new int[]{1, 2, 3, 4});
        ListNode result2 = solution.oddEvenList(node2);
        printLinkedList(result2);

        System.out.println("------");


        ListNode node3 = createListNode(new int[]{1, 2});
        ListNode result3 = solution.oddEvenList(node3);
        printLinkedList(result3);
    }

    public static ListNode createListNode(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode curNode = head;
        for (int i = 1; i < nums.length; i++) {
            curNode.next = new ListNode(nums[i]);
            curNode = curNode.next;
        }
        return head;
    }

    // 超级简单的一个工具方法
    public static void printLinkedList(ListNode head) {
        ListNode curNode = head;
        while (curNode != null) {
            System.out.printf("%s\t", curNode.val);
            curNode = curNode.next;
        }
        System.out.printf("null");
    }
}
