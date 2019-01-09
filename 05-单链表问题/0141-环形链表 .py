# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None
# 141. 环形链表
# 给定一个链表，判断链表中是否有环。

# 下面给出了使用快慢指针最容易理解的代码

class Solution(object):

    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if head is None or head.next is None:
            return False

        slow = head
        # 快指针先走一步
        fast = head.next
        while slow != fast:
            if fast is None or fast.next is None:
                return False
            slow = slow.next
            fast = fast.next.next
        return True