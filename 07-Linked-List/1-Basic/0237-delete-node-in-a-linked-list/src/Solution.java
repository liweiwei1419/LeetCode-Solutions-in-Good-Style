public class Solution {

    public void deleteNode(ListNode node) {
        // 第 1 步：把待删除结点的下一结点的值赋值给自己
        ListNode nextNode = node.next;
        node.val = nextNode.val;

        // 第 2 步：删除下一个结点
        node.next = nextNode.next;
        nextNode.next = null;
    }
}