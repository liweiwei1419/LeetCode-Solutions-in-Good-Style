import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        List<Integer> res = new ArrayList<>();
        printListFromTailToHead(head, res);

        // 这里代码有点长，但做的事情只是把 res 转到 int[]
        int size = res.size();
        int[] resArray = new int[size];
        for (int i = 0; i < size; i++) {
            resArray[i] = res.get(i);
        }
        return resArray;
    }

    private void printListFromTailToHead(ListNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        // 如果有后继结点，就一直递归下去
        if (node.next != null) {
            printListFromTailToHead(node.next, res);
        }
        // 重点：在递归返回的时候把当前结点的值添加到结果列表中
        res.add(node.val);
    }
}