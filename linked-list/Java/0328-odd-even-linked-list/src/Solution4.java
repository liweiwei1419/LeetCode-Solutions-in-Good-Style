public class Solution4 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddHead = head;
        ListNode evenHead = oddHead.next;
        ListNode oddNode = oddHead;
        ListNode evenNode = evenHead;
        ListNode currentNode = evenHead.next;
        boolean isodd = true;
        while (currentNode != null) {
            if (isodd) {
                oddNode.next = currentNode;
                oddNode = currentNode;
            } else {
                evenNode.next = currentNode;
                evenNode = currentNode;
            }
            isodd = !isodd;
            currentNode = currentNode.next;
        }
        isodd = !isodd;
        if (isodd) {
            oddNode.next = evenHead;
            evenNode.next = null;
        } else {
            oddNode.next = evenHead;
        }
        return oddHead;
    }


    public static void main(String[] args) {
        ListNode node1 = createListNode(new int[]{1, 2, 3, 4, 5});
        Solution solution = new Solution();
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
