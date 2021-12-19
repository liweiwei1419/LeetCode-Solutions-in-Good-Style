import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> array = new ArrayList<>();

        // 步骤 1：把所有链表的值放在一个动态数组里
        for (ListNode head : lists) {
            if (head != null) {
                ListNode curNode = head;
                while (curNode != null) {
                    array.add(curNode.val);
                    curNode = curNode.next;
                }
            }
        }

        // 步骤 2：集合类需要使用 Collections 工具类完成排序
        Collections.sort(array);

        // 步骤 3：根据动态数组的值生成新链表
        ListNode dummyNode = new ListNode(-1);
        ListNode curNode = dummyNode;
        for (Integer num : array) {
            curNode.next = new ListNode(num);
            curNode = curNode.next;
        }
        return dummyNode.next;
    }
}