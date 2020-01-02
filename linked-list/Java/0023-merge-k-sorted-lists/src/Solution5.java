import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution5 {

    // 添加了注释，另外传入优先队列的比较器的语法不同，仅此而已

    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(len, Comparator.comparingInt(a -> a.val));
        ListNode dummyNode = new ListNode(-1);
        ListNode curNode = dummyNode;
        for (ListNode list : lists) {
            if (list != null) {
                // 这一步很关键，不能也没有必要将空对象添加到优先队列中
                minHeap.add(list);
            }
        }
        while (!minHeap.isEmpty()) {
            // 优先队列非空才能出队
            ListNode node = minHeap.poll();
            // 当前节点的 next 指针指向出队元素
            curNode.next = node;
            // 当前指针向前移动一个元素，指向了刚刚出队的那个元素
            curNode = curNode.next;
            if (curNode.next != null) {
                // 只有非空节点才能加入到优先队列中
                minHeap.add(curNode.next);
            }
        }
        return dummyNode.next;
    }
}