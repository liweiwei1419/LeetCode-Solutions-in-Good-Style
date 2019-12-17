class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head

        dummy = ListNode(-1)
        dummy.next = head
        cur = dummy

        while cur.next and cur.next.next:
            if cur.next.val == cur.next.next.val:
                # 继续往后看，有没有相等的元素
                # del_node 至少删掉它
                del_node = cur.next.next
                while del_node.next and del_node.val == del_node.next.val:
                    del_node = del_node.next
                # 开始删除操作
                cur.next = del_node.next
                del_node.next = None
            else:
                cur = cur.next
        return dummy.next
