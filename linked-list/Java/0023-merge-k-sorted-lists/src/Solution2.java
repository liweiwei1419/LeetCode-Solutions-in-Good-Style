import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2 {

    // 代码同 Solution，添加了注释，另外传入优先队列的比较器的语法不同，仅此而已

    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(len, Comparator.comparingInt(a -> a.val));
        ListNode dummyNode = new ListNode(-1);
        ListNode curNode = dummyNode;
        for (ListNode list : lists) {
            if (list != null) {
                // 这一步很关键，不能也没有必要将空对象添加到优先队列中
                priorityQueue.add(list);
            }
        }
        while (!priorityQueue.isEmpty()) {
            // 优先队列非空才能出队
            ListNode node = priorityQueue.poll();
            // 当前节点的 next 指针指向出队元素
            curNode.next = node;
            // 当前指针向前移动一个元素，指向了刚刚出队的那个元素
            curNode = curNode.next;
            if (curNode.next != null) {
                // 只有非空节点才能加入到优先队列中
                priorityQueue.add(curNode.next);
            }
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        Integer[] nums1 = {1, 4, 5};
        Integer[] nums2 = {1, 3, 4};
        Integer[] nums3 = {2, 6};
        ListNode head1 = new ListNode(nums1);
        ListNode head2 = new ListNode(nums2);
        ListNode head3 = new ListNode(nums3);
        ListNode[] lists = new ListNode[3];
        lists[0] = head1;
        lists[1] = head2;
        lists[2] = head3;
        Solution2 solution2 = new Solution2();
        ListNode mergeKLists = solution2.mergeKLists(lists);
        System.out.println(mergeKLists);
    }
}
