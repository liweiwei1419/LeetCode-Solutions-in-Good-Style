import java.util.Comparator;
import java.util.PriorityQueue;

class Solution4 {

    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(len, Comparator.comparingInt(o -> o.val));
        for (int i = 0; i < len; i++) {
            if (lists[i] != null) {
                minHeap.offer(lists[i]);
            }
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode curNode = dummyNode;
        while (!minHeap.isEmpty()){
            ListNode top = minHeap.poll();
            curNode.next = top;

            curNode = curNode.next;

            if (top.next != null){
                minHeap.offer(top.next);
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
        Solution4 solution4 = new Solution4();
        ListNode mergeKLists = solution4.mergeKLists(lists);
        System.out.println(mergeKLists);
    }


}