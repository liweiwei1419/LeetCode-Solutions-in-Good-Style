class Solution3 {

    // 这是一个查看递归过程的代码

    // 这是一个递归方法，首先处理递归到底的情况

    public ListNode removeElements(ListNode head, int val, int depth) {
        String depthString = generateDepth(depth);
        System.out.print(depthString);
        System.out.println("call removeElements：" + val + " in " + head);
        if (head == null) {
            System.out.print(depthString);
            System.out.println("Return （at buttom）：" + head);
            return head;
        }
        ListNode res = removeElements(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println("After remove " + val + ": " + res);
        ListNode ret;
        if (head.val == val) {
            ret = res;
        } else {
            head.next = res;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return（at middle）：" + ret);
        return ret;
    }

    private String generateDepth(int depth) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            s.append("--");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        Solution3 solution3 = new Solution3();
        solution3.removeElements(head, 6, 0);
        System.out.println(head);
    }
}
