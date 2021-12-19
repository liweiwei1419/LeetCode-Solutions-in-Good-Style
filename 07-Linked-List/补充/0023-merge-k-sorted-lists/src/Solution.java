import java.util.ArrayList;
import java.util.Collections;
import java.util.List;




public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> arr = new ArrayList<>();

        for (ListNode listNode : lists) {
            if (listNode != null) {
                ListNode curNode = listNode;
                while (curNode != null) {
                    arr.add(curNode.val);
                    curNode = curNode.next;
                }
            }
        }

        Collections.sort(arr);

        ListNode dummyNode = new ListNode(-1);
        ListNode curNode = dummyNode;
        int size = arr.size();
        for (int i = 0; i < size; i++) {
            curNode.next = new ListNode(arr.get(i));
            curNode = curNode.next;
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

        Solution solution = new Solution();
        ListNode res = solution.mergeKLists(lists);
        System.out.println(res);
    }
}
