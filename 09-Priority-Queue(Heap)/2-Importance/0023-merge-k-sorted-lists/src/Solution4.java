import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution4 {

    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(len, Comparator.comparingInt(o -> o.val));
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.offer(head);
            }
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode curNode = dummyNode;
        while (!minHeap.isEmpty()) {
            // 注意：这里我们选择的操作是先从优先队列里拿出最小的元素，然后再添加
            // 事实上，如果优先队列有提供 replace 操作，应该优先选择 replace
            ListNode top = minHeap.poll();
            curNode.next = top;

            curNode = curNode.next;

            if (top.next != null) {
                minHeap.offer(top.next);
            }
        }
        return dummyNode.next;
    }
}