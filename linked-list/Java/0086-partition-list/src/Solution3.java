import java.util.ArrayList;
import java.util.List;

/**
 * Created by liwei on 17/9/14.
 * 思路分析：
 * 使用一个数组，作为中介。
 * 遍历两遍原始单链表：第 1 遍，把小于 x 的元素依次放进去；
 * 第 2 遍，把大于等于 x 的元素依次放进去
 * 此时这个数组的元素的顺序就是链表最终要求的顺序。
 * 然后，我们把中介数组转换为我们要的 ListNode 就可以了。
 */
public class Solution3 {

    public ListNode partition(ListNode head, int x) {
        // 如果这个单链表没有元素
        // 或者这个单链表只有一个元素
        // 直接把这个单链表返回回去就可以了
        if (head == null || head.next == null) {
            return head;
        }
        List<ListNode> arr = new ArrayList<>();
        ListNode currentNode = head;
        while (currentNode != null) {
            if (currentNode.val < x) {
                arr.add(currentNode);
            }
            // 这一行几乎是模板代码，
            // 意思就是指针向后挪一位
            currentNode = currentNode.next;
        }
        // 把指针复位，再来一遍
        currentNode = head;
        while (currentNode != null) {
            if (currentNode.val >= x) {
                arr.add(currentNode);
            }
            currentNode = currentNode.next;
        }

        // 然后从头到尾赋值
        // 注意：之前的操作只是把 currentNode 放进去，没有管 next 是如何放置的
        // 也就是说此时这个数组中的 ListNode 的 next 全是乱的
        // 所以现在我们要通过遍历数组，重新定义每个元素的 next 指针的指向
        for (int i = 0; i < arr.size() - 1; i++) {
            arr.get(i).next = arr.get(i + 1);
        }
        // 特别注意：最后一个元素的 next 指针应该特别地指向 null
        arr.get(arr.size() - 1).next = null;
        head = arr.get(0);
        return head;
    }
}
